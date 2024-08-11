import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Resource resource = new Resource();
        resource.putResource("apple");
        resource.addResourceQuantity("apple");
        resource.addResourceQuantity("banana");
        resource.useResourceQuantity("apple");
        resource.useResourceQuantity("banana");
        resource.printResourceInformation("apple");
        resource.printResourceInformation("banana");

        Creature creature = new Creature();
        creature.addCreature("tiger");
        creature.printCreature("tiger");
        creature.printCreature("lion");
    }
}