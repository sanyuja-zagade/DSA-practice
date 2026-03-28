package StackImplementation;

import java.util.LinkedList;
import java.util.Queue;

// SC -> O(N)
public class QueueStack {
    Queue<Integer> q = new LinkedList<>();

    // Push
    // TC -> O(N)
    public void push(int x) {
        q.add(x);
        for (int i=0; i<q.size(); i++) {
            q.add(q.poll());    // q.poll = removes & returns front element, q.add = adds element at back
        }
    }
    // Pop
    // TC -> O(1)
    public int pop() {
        int poppedEle = q.peek();   // q.peek = returns front element
        q.poll();
        return poppedEle;
    }
    // Top
    // TC -> O(1)
    public int top() {
        return q.peek();
    }
    // IsEmpty
    // TC -> O(1)
    public boolean isEmpty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(5);
        stack.push(8);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
    }
}
