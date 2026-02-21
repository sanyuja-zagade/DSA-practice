package LLProblems;

import java.util.HashMap;

public class LengthOfLoop {
    // BRUTE APPROACH
    // TC -> O(N * 2(1))
    // SC -> O(N)
    public static int LengthOfLoopBrute(Node head) {
        Node temp = head;
        HashMap<Node, Integer> mpp = new HashMap<>();
        int totalLength = 1;
        while (temp != null) {
            if (mpp.containsKey(temp)) {
                return totalLength - mpp.get(temp);
            }
            mpp.put(temp, totalLength);
            totalLength++;
            temp = temp.next;
        }
        return 0;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static int lengthOfLoopOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                slow = slow.next;
                while (slow != fast) {
                    count++;
                    slow = slow.next;
                }
                return count;
            }
        }
        return 0;
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

//        int length = LengthOfLoopBrute(head);
        int length = lengthOfLoopOptimal(head);

        System.out.println(length);
    }
}
