import java.util.Arrays;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        try {
            data[size++] = element;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Stack is full! " + e.getMessage());
        }
    }
    public T pop() {
        try {
            T res = data[--size];
            data[size] = null;
            return res;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Stack is empty! " + e.getMessage());
            return null;
        }
    }
    public T peek() {
        try {
            return data[size-1];
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Stack is empty! " + e.getMessage());
            return null;
        }
    }
    public String toString() {
        return Arrays.toString(data);
    }
    public int size() {
        return size;
    }
}