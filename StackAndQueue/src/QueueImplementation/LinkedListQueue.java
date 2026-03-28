package QueueImplementation;

// TC -> O(1)
// SC -> O(N)
class Node {
    int data;
    Node next;
    public Node(int data1) {
        data = data1;
        next = null;
    }
}
public class LinkedListQueue {
    private Node start;
    private Node end;
    private int size;

    // Constructor
    public LinkedListQueue() {
        start = end = null;
        size = 0;
    }
    // Push
    public void push(int x) {
        Node newNode = new Node(x);
        if (end == null) {
            start = end = newNode;
        }
        else {
            end.next = newNode;
            end = newNode;
        }
        size++;
    }
    // Pop
    public int pop() {
        if (start == null) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        int poppedEle = start.data;
        start = start.next;
        size--;
        return poppedEle;
    }
    // Front
    public int front() {
        if (start == null) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return start.data;
    }
    // IsEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String args[]) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.push(10);
        queue.push(5);
        queue.push(8);
        System.out.println(queue.front());
        System.out.println(queue.pop());
        System.out.println(queue.front());
        System.out.println(queue.isEmpty());
    }
}
