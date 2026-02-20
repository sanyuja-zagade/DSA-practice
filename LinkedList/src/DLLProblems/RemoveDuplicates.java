// Q. Remove all the duplicates from sorted DLL

package DLLProblems;

public class RemoveDuplicates {
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

    // TC -> O(N)
    // SC -> O(1)
    public static Node DuplicateRemoval(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;
            while (nextNode != null && nextNode.data == temp.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null) nextNode.prev = temp;
            temp = nextNode;
        }
        return head;
    }

    public static void main(String args[]) {
        int arr[] = {1, 1, 1, 2, 2, 3, 3, 4, 4, 4};
        Node head = InitializeDLL(arr);

        head = DuplicateRemoval(head);

        PrintDLL(head);
    }
}
