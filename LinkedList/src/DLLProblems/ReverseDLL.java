package DLLProblems;

import java.util.Stack;

public class ReverseDLL {
    public static Node InitializeDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i], mover, null);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }
    public static void PrintDLL(Node head) {
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
        if (head == null || head.next == null) return head;
        Node temp = head;
        Node prevNode = null;
        while (temp != null) {
            prevNode = temp.prev;
            temp.prev = temp.next;
            temp.next = prevNode;
            temp = temp.prev;
        }
        return prevNode.prev;
    }

    public static void main(String args[]) {
        int arr[] = {12, 3, 5, 8};
        Node head  = InitializeDLL(arr);

//        head = ReverseBrute(head);
        head = ReverseOptimal(head);

        PrintDLL(head);
    }
}
