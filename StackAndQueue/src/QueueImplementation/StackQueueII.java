package QueueImplementation;

import java.util.Stack;

public class StackQueueII {
    private Stack<Integer> st1, st2;

    // Constructor
    public StackQueueII() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    // Push
    public void push(int x) {
        st1.push(x);
    }
    // Pop
    public int pop() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) st2.push(st1.pop());
        }
        if (st2.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return st2.pop();
    }
    // Front
    public int front() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) st2.push(st1.pop());
        }
        if (st2.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return st2.peek();
    }
    // IsEmpty
    public boolean isEmpty() {
        return st1.isEmpty() && st2.isEmpty();
    }

    public static void main(String args[]) {
        StackQueueII queue = new StackQueueII();
        queue.push(10);
        queue.push(5);
        queue.push(8);
        System.out.println(queue.front());
        System.out.println(queue.pop());
        System.out.println(queue.front());
        System.out.println(queue.isEmpty());
    }
}
