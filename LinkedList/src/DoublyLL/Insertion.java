package DoublyLL;

public class Insertion {
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
    public static Node InsertAtHead(Node head, int ele) {
        if (head == null) return new Node(ele);
        Node newNode = new Node(ele, null, head);
        head.prev = newNode;
        return newNode;
    }

    // TC -> O(N)
    public static Node InsertAtTail(Node head, int ele) {
        if (head == null) return new Node(ele);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(ele, temp, null);
        temp.next = newNode;
        return head;
    }

    // TC -> O(N)
    public static Node InsertBeforeTail(Node head, int ele) {
        if (head == null) return new Node(ele);
        if (head.next == null) {
            Node newNode = new Node(ele, null, head);
            head.prev = newNode;
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node prevNode = temp.prev;
        Node newNode = new Node(ele, prevNode, temp);
        prevNode.next = newNode;
        temp.prev = newNode;
        return head;
    }

    // Given - position will always be in the range of the list
    // TC -> O(pos)
    //    -> O(1) [Best case]
    //    -> O(N) [Worst case]
    public static Node InsertAtPosition(Node head, int ele, int pos) {
        if (head == null && pos != 1) return null;
        if (pos == 1) {
            if (head == null)
                return new Node(ele);
            Node newNode = new Node(ele, null, head);
            head.prev = newNode;
            return newNode;
        }
        int count = 0;
        Node temp = head;
        while (temp.next != null) {
            count++;
            if (count == pos) break;
            temp = temp.next;
        }
        if (temp.next == null) {
            Node newNode = new Node(ele, temp, null);
            temp.next = newNode;
        }
        else {
            Node prevNode = temp.prev;
            Node newNode = new Node(ele, prevNode, temp);
            prevNode.next = newNode;
            temp.prev = newNode;
        }
        return head;
    }

    // Given - node will be never head
    // TC -> O(1)
    public static void InsertBeforeNode(Node node, int ele) {
        Node prevNode = node.prev;
        Node newNode = new Node(ele, prevNode, node);
        prevNode.next = newNode;
        node.prev = newNode;
    }

    // Given - node will be never head
    // TC -> O(1)
    public static void InsertAfterNode(Node node, int ele) {
        if (node.next == null) {
            Node newNode = new Node(ele, node, null);
            node.next = newNode;
        }
        else {
            Node nextNode = node.next;
            Node newNode = new Node(ele, node, nextNode);
            nextNode.prev = newNode;
            node.next = newNode;
        }
    }

    public static void main(String args[]) {
        int arr[] = {12, 3, 5, 8};
        Node head = InitializeDLL(arr);

//        head = InsertAtHead(head, 100);
//        head = InsertAtTail(head, 100);
//        head = InsertBeforeTail(head, 100);
//        head = InsertAtPosition(head, 100, 1);
//        InsertBeforeNode(head.next.next.next, 100);
        InsertAfterNode(head.next.next.next, 100);

        PrintDLL(head);
    }
}
