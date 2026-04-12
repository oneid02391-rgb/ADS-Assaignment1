import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr = new Object[5];
    private int size = 0;

    private void grow() {
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void add(T item) {
        addLast(item);
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) return;
        if (size == arr.length) grow();

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = item;
        size++;
    }

    public void addFirst(T item) {
        add(0, item);
    }

    public void addLast(T item) {
        if (size == arr.length) grow();
        arr[size] = item;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return (T) arr[index];
    }

    public T getFirst() {
        if (size == 0) return null;
        return (T) arr[0];
    }

    public T getLast() {
        if (size == 0) return null;
        return (T) arr[size - 1];
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) return;
        arr[index] = item;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) return;

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[size - 1] = null;
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        if (size == 0) return;
        arr[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(o)) return i;
        }
        return -1;
    }

    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                T a = (T) arr[j];
                T b = (T) arr[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public Object[] toArray() {
        Object[] res = new Object[size];
        for (int i = 0; i < size; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cur = 0;

            public boolean hasNext() {
                return cur < size;
            }

            public T next() {
                return (T) arr[cur++];
            }
        };
    }
}
