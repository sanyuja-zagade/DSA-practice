// Q. Segregate LL according to its odd & even indices

package LLProblems;

import java.util.ArrayList;

public class SegregateOddEven {
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
    public static void PrintLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // BRUTE APPROACH
    // TC -> O(2N)
    // SC -> O(N)
    public static Node OddEvenBrute(Node head) {
        if (head == null || head.next == null) return head;
        Node temp = head;
        ArrayList<Integer> ls = new ArrayList<>();
        while (temp != null && temp.next != null) {
            ls.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) ls.add(temp.data);

        temp = head.next;
        while (temp != null && temp.next != null) {
            ls.add(temp.data);
            temp = temp.next.next;
        }

        temp = head;
        for (int i=0; i<ls.size(); i++) {
            temp.data = ls.get(i);
            temp = temp.next;
        }

        return head;
    }

    // OPTIMAL APPROACH
    // TC -> O(N) * 2 -> O(N)
    // SC -> O(1)
    public static Node OddEvenOptimal(Node head) {
        if (head == null || head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node evenStart = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenStart;
        return head;
    }

    public static void main(String args[]) {
        int arr[] = {1, 4, 3, 7, 5, 6};
        Node head = InitializeLL(arr);

//        head = OddEvenBrute(head);
        head = OddEvenOptimal(head);

        PrintLL(head);
    }
}
