package DoublyLL;

public class Deletion {
    public static Node InitializeDLL(int arr[]) {
        if (arr.length == 0) return null;
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

    // TC -> O(1)
    public static Node DeleteHead(Node head) {
        if (head == null || head.next == null) return null;
        Node prevNode = head;
        head = head.next;
        head.prev = null;
        prevNode.next = null;
        return head;
    }


    // TC -> O(N)
    public static Node DeleteTail(Node head) {
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node prevNode = temp.prev;
        prevNode.next = null;
        temp.prev = null;
        return head;
    }

    // TC -> O(pos)
    //    -> O(1) [Best case]
    //    -> O(N) [Worst case]
     public static Node DeleteAtPosition(Node head, int pos) {
        if (head == null) return null;
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == pos) break;
            temp = temp.next;
        }
        Node prevNode = temp.prev;
        Node nextNode = temp.next;
        if (prevNode == null && nextNode == null) return null;
        else if (prevNode == null){
            nextNode.prev = null;
            temp.next = null;
            return nextNode;
        }
        else if (nextNode == null) {
            temp.prev = null;
            prevNode.next = null;
            return head;
        }
        else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            temp.next = null;
            temp.prev = null;
        }
        return head;
    }

    // Given - node can never be head
    // TC -> O(1)
    public static void DeleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        if (nextNode == null) {
            prevNode.next = null;
            node.prev = null;
            return;
        }
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;
        node.prev = null;
    }

    public static void main(String args[]) {
        int arr[] = {12, 3, 5, 8};
        Node head = InitializeDLL(arr);

//        head = DeleteHead(head);
//        head = DeleteTail(head);
//        head = DeleteAtPosition(head, 1);
        DeleteNode(head.next.next.next);

        PrintDLL(head);
    }
}
