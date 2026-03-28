package StackImplementation;

// TC -> O(1)
// SC -> O(N)
class Node {
    int data;
    Node next;
    Node (int data1) {
        data = data1;
        next = null;
    }
}
public class LinkedListStack {
    private Node head;
    private int size;

    // Constructor
    public LinkedListStack() {
        head = null;
        size = 0;
    }
    // Push
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
    }
    // Pop
    public int pop() {
        if (head == null) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        int poppedEle = head.data;
        head = head.next;
        size--;
        return poppedEle;
    }
    // Top
    public int top() {
        if (head == null) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return head.data;
    }
    // IsEmpty
    public boolean isEmpty() {
        return head == null;
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
