import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Resource implements Management{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Map<String, Integer> resources = new HashMap<>();
    private String elementErrorMessage;

    //새로운 자원을 생성하는 메소드
    @Override
    public void createElement(String elementName) {
        if (resources.containsKey(elementName)){
            System.out.println(elementName+"라는 이름의 자원이 이미 존재합니다.");
        }
        else{
            try {
                System.out.println("자원의 이름: " + elementName);
                System.out.print("자원의 양: ");

                String elementQuantityToSet = br.readLine();

                elementErrorMessage = "자원의 양은 양수로 입력 되어야 합니다.";
                int elementQuantity = validateElement(elementQuantityToSet,elementErrorMessage);

                System.out.println("현재 자원의 양: " + elementQuantity);
                resources.put(elementName, elementQuantity);

            } catch (Exception e) {
                handleExceptions(e);
            }
        }
    }

    //자원을 삭제하는 메소드
    @Override
    public void deleteElement(String elementName) {
        if (resources.containsKey(elementName)){
            resources.remove(elementName);
        }
        else {
            System.out.println(elementName+"라는 이름의 자원은 존재하지 않습니다.");
        }
    }

    //자원 정보를 출력하는 메소드
    @Override
    public void printElements(String elementName) {
        if (resources.containsKey(elementName)){
            System.out.println("자원 정보");
            System.out.println("\t자원 이름: "+elementName);
            System.out.println("\t자원 양: "+resources.get(elementName));
        }
        else {
            System.out.println(elementName+"라는 이름의 자원 정보를 조회할 수 없습니다.");
        }
    }

    //자원의 양을 더하는 메소드
    public void addElementQuantity(String elementName) {
        if (resources.containsKey(elementName)){
            try {
                System.out.println("자원의 이름: " + elementName);
                System.out.print("추가할 자원의 양: ");

                String elementQuantityToAdd = br.readLine();

                elementErrorMessage = "추가할 자원의 양은 양수로 입력 되어야 합니다.";
                int elementQuantity = validateElement(elementQuantityToAdd,elementErrorMessage);
                elementQuantity = validateElement(String.valueOf(elementQuantity+resources.get(elementName)),elementErrorMessage);

                System.out.println("현재 자원의 양: " + elementQuantity);
                resources.put(elementName, elementQuantity);

            } catch (Exception e) {
                handleExceptions(e);
                addElementQuantity(elementName);
            }
        }
        else {
            System.out.println(elementName+"라는 이름의 자원은 존재하지 않습니다.");
        }
    }

    //자원을 사용하는 메소드
    public void useElementQuantity(String elementName) {
        if (resources.containsKey(elementName)){
            try {
                System.out.println("자원의 이름: " + elementName);
                System.out.print("사용할 자원의 양: ");

                String elementQuantityToUse = br.readLine();

                elementErrorMessage = "사용할 자원의 양은 양수로 입력 되어야 합니다.";
                int elementQuantity = validateElement(elementQuantityToUse,elementErrorMessage);
                elementErrorMessage = "사용할 자원의 양은 존재하는 자원의 양보다 많을 수 없습니다.";
                elementQuantity = validateElement(String.valueOf(resources.get(elementName)-elementQuantity),elementErrorMessage);

                System.out.println("현재 자원의 양: " + elementQuantity);
                resources.put(elementName, elementQuantity);

            } catch (Exception e) {
                handleExceptions(e);
                useElementQuantity(elementName);
            }
        }
        else {
            System.out.println(elementName+"라는 이름의 자원은 존재하지 않습니다.");
        }
    }

    //확인하는 메소드
    private int validateElement(String elementQuantity, String elementErrorMessage) {

        //trim().isEmpty() -> 공백이 있는 문자열도 빈문자열도 체크할 수 있다.
        //숫자는 중간에 비어있으면 안됨
        if (elementQuantity == null || elementQuantity.trim().isEmpty()) {
            throw new NoSuchElementException("자원의 양을 입력 해주세요.");
        }

        int quantity = Integer.parseInt(elementQuantity);

        if (quantity < 0) {
            throw new IllegalArgumentException(elementErrorMessage);
        }

        return quantity;
    }

    // 예외를 처리하는 메소드
    private void handleExceptions(Exception e) {

        //instanceof 를 안쓰면 오류는 없지만
        //각 타입별로 catch 를 만들어야한다.
        if (e instanceof NumberFormatException) {
            System.out.println("정수를 적었는데 이 메세지가 뜨는 경우 숫자의 공백을 제거해주세요.");
        }

        //음수인 경우
        else if (e instanceof IllegalArgumentException || e instanceof NoSuchElementException) {
            System.out.println(e.getMessage());
        }

        //입출력 과정에서 발생할 수 있는 오류를 나타내는 예외
        else if (e instanceof IOException) {
            System.out.println(e.getMessage());
        }

        else {
            System.out.println(e.getMessage());
        }
    }
}