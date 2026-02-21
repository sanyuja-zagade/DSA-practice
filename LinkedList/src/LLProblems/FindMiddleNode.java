package LLProblems;

public class FindMiddleNode {
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

    // BRUTE APPROACH
    // TC -> O(N + N/2)
    // SC -> O(1)
    public static Node FindMiddleNodeBrute(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int middle = (count/2) + 1;
        temp = head;
        while (temp != null) {
            middle = middle - 1;
            if (middle == 0) break;
            temp = temp.next;
        }
        return temp;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static Node FindMiddleNodeOptimal(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 6, 5};
        Node head = InitializeLL(arr);

//        Node middleNode = FindMiddleNodeBrute(head);
        Node middleNode = FindMiddleNodeOptimal(head);

        System.out.print(middleNode.data);
    }
}
