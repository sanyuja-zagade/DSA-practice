public class BasicOperations {
    // Initializing LL for array
    private static Node InitializeLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    // Traversing LL
    private static void TraverseLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Length of LL
    private static int LengthOfLL(Node head) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Searching element in LL
    private static int SearchInLL(Node head, int ele) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == ele) return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {12, 3, 5, 6};

        Node head = InitializeLL(arr);
        System.out.println(head.data);

        TraverseLL(head);

        int length = LengthOfLL(head);
        System.out.println(length);

        int search = SearchInLL(head, 5);
        System.out.println(search);
    }
}
