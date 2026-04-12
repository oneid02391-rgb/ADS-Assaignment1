public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list = new MyArrayList<T>();

    public void insert(T item) {
        list.addLast(item);
        int i = list.size() - 1;

        while (i > 0) {
            int p = (i - 1) / 2;
            if (list.get(i).compareTo(list.get(p)) < 0) {
                T temp = list.get(i);
                list.set(i, list.get(p));
                list.set(p, temp);
                i = p;
            } else {
                break;
            }
        }
    }

    public T getMin() {
        return list.get(0);
    }

    public T extractMin() {
        if (list.size() == 0) return null;

        T min = list.get(0);
        T last = list.getLast();

        list.set(0, last);
        list.removeLast();

        int i = 0;
        while (true) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            int smallest = i;

            if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
                smallest = left;
            }

            if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != i) {
                T temp = list.get(i);
                list.set(i, list.get(smallest));
                list.set(smallest, temp);
                i = smallest;
            } else {
                break;
            }
        }

        return min;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
