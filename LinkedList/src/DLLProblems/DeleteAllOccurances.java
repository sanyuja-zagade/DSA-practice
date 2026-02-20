package DLLProblems;

public class DeleteAllOccurances {
    public static Node InitializeDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i< arr.length; i++) {
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
    public static Node DeleteOccurances(Node head, int k) {
        if (head == null) return head;
        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null) head.prev = null;
                };
                Node nextNode = temp.next;
                Node prevNode = temp.prev;
                if (nextNode != null) nextNode.prev = prevNode;
                if (prevNode != null) prevNode.next = nextNode;
                temp = nextNode;
            }
            else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String args[]) {
        int arr[] = {10, 4, 10, 10, 6, 10};
        Node head = InitializeDLL(arr);

        head = DeleteOccurances(head, 10);

        PrintDLL(head);
    }
}
