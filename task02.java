import java.util.LinkedList;

public class task02 {
    private LinkedList<Integer> queue;

    public task02() {
        queue = new LinkedList<>();
    }

    public void enqueue(int element) {
        queue.addLast(element);
    }

    public int dequeue() {
        return queue.removeFirst();
    }

    public int first() {
        return queue.getFirst();
    }

    public static void main(String[] args) {
        task02 queueExample = new task02();
        queueExample.enqueue(1);
        queueExample.enqueue(2);
        queueExample.enqueue(3);
        queueExample.enqueue(4);
        queueExample.enqueue(5);
        queueExample.enqueue(6);
        queueExample.enqueue(7);
        System.out.println(queueExample.queue);

        queueExample.enqueue(8);
        System.out.println(queueExample.queue);

        int dequeuedElement = queueExample.dequeue();
        System.out.println(dequeuedElement);
        System.out.println(queueExample.queue);

        int firstElement = queueExample.first();
        System.out.println(firstElement);
        System.out.println(queueExample.queue);
    }
}
