package LLProblems;

import java.util.Stack;

public class ReverseLL {
    public static Node InitializeLL(int arr[]) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    public static void PrintLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // BRUTE APPROACH
    // TC -> O(2N)
    // SC -> O(N)
    public static Node ReverseBrute(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        Stack<Integer> stk = new Stack<>();
        while (temp != null) {
            stk.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stk.pop();
            temp = temp.next;
        }
        return head;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static Node ReverseOptimal(Node head) {
        Node temp = head;
        Node prevNode = null;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
        return prevNode;
    }

    // RECURSIVE APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static Node ReverseRecursive(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = ReverseRecursive(head.next);
        Node nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 6, 5};
        Node head = InitializeLL(arr);

//        head = ReverseBrute(head);
//        head = ReverseOptimal(head);
        head = ReverseRecursive(head);

        PrintLL(head);
    }
}
