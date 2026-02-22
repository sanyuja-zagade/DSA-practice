package LLProblems;

public class DeleteMiddleNode {
    public static Node InitializeLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
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
    // TC -> O(N + N/2)
    // SC -> O(1)
    public static Node DeleteMiddleNodeBrute(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int middle = length / 2;
        temp = head;
        while (temp != null) {
            middle--;
            if (middle == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // OPTIMAL APPROACH
    // TC -> O(N/2)
    // SC -> O(1)
    public static Node DeleteMiddleNodeOptimal(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String args[]) {
        int arr[] = {1, 4, 3, 7, 5, 6};
        Node head = InitializeLL(arr);

//        head = DeleteMiddleNodeBrute(head);
        head = DeleteMiddleNodeOptimal(head);

        PrintLL(head);
    }
}
