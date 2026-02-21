package LLProblems;

import java.util.HashMap;

public class StartingNodeOfLoop {
    // BRUTE APPROACH
    // TC -> O(N * 2(1))
    // SC -> O(N)
    public static Node FindStartingNodeBrute(Node head) {
        Node temp = head;
        HashMap<Node, Integer> mpp = new HashMap<>();
        while (temp != null) {
            if (mpp.containsKey(temp)) return temp;
            mpp.put(temp, 1);
            temp = temp.next;
        }
        return null;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static Node FindStartingNodeOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String args[]) {
            Node head = new Node(1);
            Node second = new Node(2);
            Node third = new Node(3);
            Node forth = new Node(4);
            Node fifth = new Node(5);

            head.next = second;
            second.next = third;
            third.next = forth;
            forth.next = fifth;
            fifth.next = third;

//            Node start = FindStartingNodeBrute(head);
        Node start = FindStartingNodeOptimal(head);

            System.out.println(start.data);
    }
}
