package LLProblems;

import java.util.Stack;

public class PalindromeLL {
    public static Node InitializeLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    // BRUTE APPROACH
    // TC -> O(N * 2(1))
    // SC -> O(N)
    public static String PalindromeCheckBrute(Node head) {
        Node temp = head;
        Stack<Integer> stk = new Stack<>();
        while (temp != null) {
            stk.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data != stk.pop()) return "NOT a Palindrome";
            temp = temp.next;
        }
        return "Yes! a Palindrome";
    }

    // OPTIMAL APPROACH
    // TC -> O(2N)
    // SC -> O(1)
    public static Node ReverseLL(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = ReverseLL(head.next);
        Node nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
    public static String PalindromeCheckOptimal(Node head) {
        if (head == null || head.next == null) return "YES! a Palindrome";
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {    // O(N/2)
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = ReverseLL(slow.next);        // O(N/2)
        Node start1 = head;
        Node start2 = newHead;
        while (start2 != null) {                    // O(N/2)
            if (start1.data != start2.data) {
                ReverseLL(newHead);                 // O(N/2)
                return "NOT a Palindrome";
            }
            start1 = start1.next;
            start2 = start2.next;
        }
        ReverseLL(newHead);
        return "YES! a Palindrome";
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 3, 2, 1};
        Node head = InitializeLL(arr);

//        String isPalindrome = PalindromeCheckBrute(head);
        String isPalindrome = PalindromeCheckOptimal(head);

        System.out.println(isPalindrome);
    }
}
