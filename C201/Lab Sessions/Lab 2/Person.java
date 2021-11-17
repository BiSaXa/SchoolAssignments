import java.util.ArrayList;

public class Person {

    public String name;
    public ArrayList<Object> boxes = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void addBox(Object box) {
        boxes.add(box);
    }

    public void printPerson() {
        StringBuilder outputBoxes = new StringBuilder();
        outputBoxes.append("Person Information:\n" + name + " has " + boxes.size() + " boxes.\n\n");
        for (Object box : boxes) {
            outputBoxes.append(box.toString() + "\n");
        }
        System.out.println(outputBoxes);
    }

}
