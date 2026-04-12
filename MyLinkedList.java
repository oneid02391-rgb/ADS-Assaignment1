import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(T item) {
        addLast(item);
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) return;
        if (index == 0) {
            addFirst(item);
            return;
        }
        if (index == size) {
            addLast(item);
            return;
        }

        Node cur = getNode(index);
        Node n = new Node(item);

        n.prev = cur.prev;
        n.next = cur;
        cur.prev.next = n;
        cur.prev = n;
        size++;
    }

    public void addFirst(T item) {
        Node n = new Node(item);

        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public void addLast(T item) {
        Node n = new Node(item);

        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    public T get(int index) {
        Node cur = getNode(index);
        if (cur == null) return null;
        return cur.data;
    }

    public T getFirst() {
        if (head == null) return null;
        return head.data;
    }

    public T getLast() {
        if (tail == null) return null;
        return tail.data;
    }

    public void set(int index, T item) {
        Node cur = getNode(index);
        if (cur != null) cur.data = item;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }

        Node cur = getNode(index);
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
        size--;
    }

    public void removeFirst() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
    }

    public void removeLast() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int indexOf(Object o) {
        Node cur = head;
        int i = 0;
        while (cur != null) {
            if (cur.data.equals(o)) return i;
            cur = cur.next;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        Node cur = tail;
        int i = size - 1;
        while (cur != null) {
            if (cur.data.equals(o)) return i;
            cur = cur.prev;
            i--;
        }
        return -1;
    }

    public boolean exists(Object o) {
        return indexOf(o) != -1;
    }

    public void sort() {
        for (int i = 0; i < size - 1; i++) {
            Node cur = head;
            while (cur != null && cur.next != null) {
                if (cur.data.compareTo(cur.next.data) > 0) {
                    T temp = cur.data;
                    cur.data = cur.next.data;
                    cur.next.data = temp;
                }
                cur = cur.next;
            }
        }
    }

    public Object[] toArray() {
        Object[] res = new Object[size];
        Node cur = head;
        int i = 0;
        while (cur != null) {
            res[i] = cur.data;
            cur = cur.next;
            i++;
        }
        return res;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) return null;
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node cur = head;

            public boolean hasNext() {
                return cur != null;
            }

            public T next() {
                T val = cur.data;
                cur = cur.next;
                return val;
            }
        };
    }
}
