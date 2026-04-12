public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> a = new MyArrayList<Integer>();
        a.add(10);
        a.add(20);
        a.addFirst(5);
        a.add(1, 7);
        print(a.toArray());
        a.sort();
        print(a.toArray());

        MyLinkedList<Integer> l = new MyLinkedList<Integer>();
        l.add(8);
        l.add(3);
        l.addLast(15);
        l.addFirst(1);
        print(l.toArray());
        l.sort();
        print(l.toArray());

        MyStack<Integer> s = new MyStack<Integer>();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println("stack peek = " + s.peek());
        System.out.println("stack pop = " + s.pop());

        MyQueue<Integer> q = new MyQueue<Integer>();
        q.enqueue(100);
        q.enqueue(200);
        q.enqueue(300);
        System.out.println("queue peek = " + q.peek());
        System.out.println("queue dequeue = " + q.dequeue());

        MyMinHeap<Integer> h = new MyMinHeap<Integer>();
        h.insert(20);
        h.insert(5);
        h.insert(15);
        h.insert(2);
        System.out.println("min = " + h.getMin());
        System.out.println("extract min = " + h.extractMin());
        System.out.println("new min = " + h.getMin());
    }

    public static void print(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
