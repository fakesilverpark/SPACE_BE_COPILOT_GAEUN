import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Resource resource = new Resource();

        //입력된 숫자가 음수, 정수를 제외한 실수, 문자열, 공백이 존재하는 숫자라면 예외처리 됩니다.

        resource.createElement("apple");
        //같은 이름의 자원을 추가할 수 없습니다.
        resource.createElement("apple");
        resource.addElementQuantity("apple");
        //존재하지 않는 자원의 양은 추가되지 않습니다.
        resource.addElementQuantity("banana");
        resource.useElementQuantity("apple");
        //존재하지 않는 자원은 사용할 수 없습니다.
        resource.useElementQuantity("banana");
        resource.printElements("apple");
        resource.deleteElement("apple");
        //자원이 제거되면 (= 자원이 존재하지 않으면) 그 자원에 대한 정보를 출력할 수 없습니다.
        resource.printElements("apple");

        Creature creature = new Creature();
        creature.createElement("tiger");
        creature.printElements("tiger");
        creature.deleteElement("tiger");
        creature.printElements("tiger");
        creature.deleteElement("lion");

    }
}