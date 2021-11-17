import java.util.ArrayList;

public class Box<E> {

    ArrayList<E> contents = new ArrayList<E>();

    public Box() {
    }

    public void add(E item) {
        contents.add(item);
    }

    public E remove() {
        E lastContent = contents.get(contents.size()-1);
        contents.remove(contents.size()-1);
        return lastContent;
    }

    @Override
    public String toString() {
        StringBuilder outputBox = new StringBuilder();
        for (int i = contents.size() - 1; i >= 0; i--) {
            outputBox.append(contents.get(i).toString());
        }
        return outputBox.toString();
    }
}
