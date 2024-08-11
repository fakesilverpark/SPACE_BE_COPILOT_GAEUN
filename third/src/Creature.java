import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Creature {
    private Map<String, String> creatures = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void addCreature(String creatureName) throws IOException {
        System.out.println("생명체의 이름: "+creatureName);
        System.out.print("생명체의 정보: ");
        String creatureInformation = br.readLine();
        creatures.put(creatureName,creatureInformation);
    }

    void printCreature(String creatureName){
        if (creatures.containsKey(creatureName)){
            System.out.println();
            System.out.println("-------------------------");
            System.out.println();
            System.out.println(" 생명체 정보");
            System.out.println("\t- 생명체 이름: "+creatureName);
            System.out.println("\t- 정보: "+creatures.get(creatureName));
            System.out.println();
            System.out.println("-------------------------");
        }
        else{
            System.out.println();
            System.out.println(creatureName+"라는 이름의 생명체 정보를 조회할 수 없습니다.");
        }
    }
}
