package LLProblems;

import java.util.HashMap;

public class LoopInLL {
    // BRUTE APPROACH
    // TC -> O(N * 2(1)) [HashMap - Ordered map]
    // SC -> O(N)
    public static Boolean DetectLoopBrute(Node head) {
        Node temp =  head;
        HashMap<Node, Integer> mpp = new HashMap<>();
        while (temp != null) {
            if (mpp.containsKey(temp)) return true;
            mpp.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }

    // OPTIMAL APPROACH - Tortoise & Hair Method
    // TC -> O(N) [Somewhere around]
    // SC -> O(1)
    public static Boolean DetectLoopOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
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

//        Boolean loopExist = DetectLoopBrute(head);
        Boolean loopExist = DetectLoopOptimal(head);

        System.out.println(loopExist);
    }
}
