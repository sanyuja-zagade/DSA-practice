package QueueImplementation;

import java.util.Stack;

// SC -> O(N)
public class StackQueue {
    private Stack<Integer> st1, st2;

    // Constructor
    public StackQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    // Push
    // TC -> O(N)
    public void push(int x) {
        while (!st1.isEmpty()) st2.push(st1.pop());
        st1.push(x);
        while (!st2.isEmpty()) st1.push(st2.pop());
    }
    // Pop
    // TC -> O(1)
    public int pop() {
        if (st1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return st1.pop();
    }
    // Front
    // TC -> O(1)
    public int front() {
        if (st1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return st1.peek();
    }
    // IsEmpty
    // TC -> O(1)
    public boolean isEmpty() {
        return st1.isEmpty();
    }

    public static void main(String args[]) {
        StackQueue queue = new StackQueue();
        queue.push(10);
        queue.push(5);
        queue.push(8);
        System.out.println(queue.front());
        System.out.println(queue.pop());
        System.out.println(queue.front());
        System.out.println(queue.isEmpty());
    }
}
