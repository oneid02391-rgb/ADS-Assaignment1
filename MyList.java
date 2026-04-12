import java.util.Iterator;

public interface MyList<T extends Comparable<T>> extends Iterable<T> {
    void add(T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);

    T get(int index);
    T getFirst();
    T getLast();

    void set(int index, T item);

    void remove(int index);
    void removeFirst();
    void removeLast();

    int size();
    void clear();

    int indexOf(Object o);
    int lastIndexOf(Object o);
    boolean exists(Object o);

    void sort();
    Object[] toArray();

    Iterator<T> iterator();
}
