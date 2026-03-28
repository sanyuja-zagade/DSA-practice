package QueueImplementation;

import StackImplementation.ArrayStack;

// TC -> O(1)
// SC -> O(N)
public class ArrayQueue {
    private int[] qArray;
    private int currSize, maxSize;
    private int start, end;

    // Constructor
    public ArrayQueue(int size) {
        qArray = new int[size];
        currSize = 0;
        maxSize = size;
        start = -1;
        end = -1;
    }
    // Push
    public void push(int x) {
        if (currSize == maxSize) {
            System.out.println("Queue is Full!");
            return;
        }
        if (end == -1) {
            start = 0;
            end = 0;
        }
        else {
            end = (end + 1) % maxSize;
        }
        qArray[end] = x;
        currSize++;
    }
    // Pop Front
    public int pop() {
        if (currSize == 0) {
            System.out.println("Queue is Empty!");
            return -1;
        }
        int popped = qArray[start];
        if (currSize == 1) {
            start = -1;
            end = -1;
        }
        else {
            start = (start + 1) % maxSize;
        }
        currSize--;
        return popped;
    }
    // Front
    public int front() {
        if (currSize == 0) {
            System.out.println("Queue is Empty!");
        }
        return qArray[start];
    }

    // IsEmpty
    public boolean isEmpty() {
        return currSize == 0;
    }
}

class Main {
    public static void main(String args[]) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.push(10);
        queue.push(5);
        queue.push(8);
        System.out.println(queue.front());
        System.out.println(queue.pop());
        System.out.println(queue.front());
        System.out.println(queue.isEmpty());
    }
}

