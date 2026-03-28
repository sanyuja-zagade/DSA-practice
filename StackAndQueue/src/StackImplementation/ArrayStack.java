package StackImplementation;

import QueueImplementation.ArrayQueue;

// TC -> O(1)
// SC -> O(N) [N = maximum capacity of stack]
public class ArrayStack {
    private int[] stackArray;
    private int capacity;
    private int topIndex;

    // Constructor
    public ArrayStack(int size) {
        stackArray = new int[size];
        capacity = size;
        topIndex = -1;
    }
    // Default Constructor
    public ArrayStack() {
        this(1000);
    }

    // Push
    public void push(int x) {
        if (topIndex >= capacity) {
            System.out.println("Stack overflow!");
            return;
        }
        stackArray[++topIndex] = x;
    }
    // Pop
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stackArray[topIndex--];
    }
    // Top
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stackArray[topIndex];
    }
    // IsEmpty
    public boolean isEmpty() {
        return topIndex == -1;
    }
}

class Main {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(5);
        stack.push(8);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
    }
}

