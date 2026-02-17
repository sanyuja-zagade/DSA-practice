public class Deletion {
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
    public static void PrintLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // TC -> O(1)
    public static Node DeleteHead(Node head) {      // !!!!!!!! Something is WRONG :(
        if (head == null) return head;
        return head.next;
    }

    // TC -> O(N)
    public static Node DeleteTail(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    // TC -> O(1) [Best case]
    //    -> O(N) [Worst case]
    //    -> O(pos)
    public static Node DeleteAtPosition(Node head, int pos) {
        if (head == null || pos <= 0) return head;
        if (pos == 1) return head.next;
        int count = 0;
        Node temp = head;
        while (temp.next != null) {
            count++;
            if (count == pos-1) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // TC -> O(1) [Best case]
    //    -> O(N) [Worst case]
    //    -> O(pos of ele)
    public static Node DeleteEle(Node head, int ele) {
        if (head == null) return head;
        if (head.data == ele) return head.next;
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == ele) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String args[]) {
        int arr[] = {12, 3, 5, 6};
        Node head = InitializeLL(arr);

//        head = DeleteHead(head);
//        head = DeleteTail(head);
//        head = DeleteAtPosition(head, 6);
        head = DeleteEle(head, 1);

        PrintLL(head);
    }
}
