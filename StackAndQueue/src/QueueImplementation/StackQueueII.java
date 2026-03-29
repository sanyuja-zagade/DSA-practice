package QueueImplementation;

import java.util.Stack;

// SC -> O(N)
public class StackQueueII {
    private Stack<Integer> st1, st2;

    // Constructor
    public StackQueueII() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    // Push
    // TC -> O(1)
    public void push(int x) {
        st1.push(x);
    }
    // Pop
    // TC -> O(N)
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
    // TC -> O(N)
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
    // TC -> O(1)
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
