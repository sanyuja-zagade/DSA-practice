package SinglyLL;

import SinglyLL.Node;

public class Insertion {
    public static Node InitializeLL(int arr[]) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i< arr.length; i++) {
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
    public static Node InsertAtHead(Node head, int ele) {
        return new Node(ele, head);
    }

    // TC -> O(N)
    public static Node InsertAtTail(Node head, int ele) {
        if (head == null) return new Node(ele);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(ele);
        return head;
    }

    // TC -> O(1) [Best case]
    //    -> O(N) [Worst case]
    //    -> O(pos)
    public static Node InsertAtPosition(Node head, int ele, int pos) {
        if (head == null || pos <= 0) return head;
        if (pos == 1) return new Node(ele, head);
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == pos-1) {
                Node newNode = new Node(ele, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // TC -> O(1) [Best case]
    //    -> O(N) [Worst case]
    //    -> O(pos of value)
    public static Node InsertBeforeValue(Node head, int ele, int val) {
        if (head == null) return head;
        if (head.data == val) return new Node(ele, head);
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                Node newNode = new Node(ele, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String args[]) {
        int arr[] = {12, 3, 5, 6};
        Node head = InitializeLL(arr);

//        head = InsertAtHead(head, 100);
//        head = InsertAtTail(head, 100);
//        head = InsertAtPosition(head, 100, 2);
        head = InsertBeforeValue(head, 100, 3);

        PrintLL(head);
    }
}
