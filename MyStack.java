public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<T>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        T val = list.getLast();
        list.removeLast();
        return val;
    }

    public T peek() {
        return list.getLast();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
