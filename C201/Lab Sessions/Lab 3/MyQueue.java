import java.util.Arrays;

public class MyQueue<E> {

    private E[] data;
    private int size;
    private int first;

    public MyQueue(int capacity) {
        data = (E[]) new Object[capacity];
        first = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        } else {
            return data[first % data.length];
        }
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            E firstElement = data[first % data.length];
            data[first] = null;
            first++;
            size--;
            return firstElement;
        }
    }

    public boolean enqueue(E e) {
        boolean state = size != data.length;
        if (state) {
            data[((first % data.length) + size) % data.length] = e;
            size++;
        }
        return state;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";
        String str = "[";
        int amount = 0;
        int i = (first % data.length);
        while(amount < size) {
            str = str + data[i % data.length];
            if (amount != size - 1)
                str = str + ", ";
            else
                str = str + "] and Inner Array: " + Arrays.toString(data);
            i++;
            amount++;
        }
        return str;
    }
}
