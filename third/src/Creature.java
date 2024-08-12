import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Creature implements Management {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Map<String, String> creatures = new HashMap<>();

    //새로운 자원을 생성하는 메소드
    @Override
    public void createElement(String elementName) throws IOException{
        if (creatures.containsKey(elementName)){
            System.out.println(elementName+"라는 이름의 생명체 정보가 이미 존재합니다.");
        }
        else{
            System.out.println("생명체의 이름: " + elementName);
            System.out.print("생명체의 설명: ");

            String elementInformation = br.readLine();

            creatures.put(elementName, elementInformation);
        }
    }
    //자원을 삭제하는 메소드
    @Override
    public void deleteElement(String elementName) {
        if (creatures.containsKey(elementName)){
            creatures.remove(elementName);
        }
        else {
            System.out.println(elementName+"라는 이름의 생명체 정보를 조회할 수 없습니다.");
        }
    }
    //자원 정보를 출력하는 메소드
    @Override
    public void printElements(String elementName) {
        if (creatures.containsKey(elementName)){
            System.out.println("생명체 정보");
            System.out.println("\t생명체의 이름: "+elementName);
            System.out.println("\t생명체의 설명: "+creatures.get(elementName));
        }
        else {
            System.out.println(elementName+"라는 이름의 생명체 정보를 조회할 수 없습니다.");
        }
    }
}