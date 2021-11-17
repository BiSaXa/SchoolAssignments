public class Pen {

    public String name;
    public String type;

    public Pen(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "(N: " + name + ", T: " + type + ")\n";
    }

}
