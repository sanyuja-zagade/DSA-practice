package DoublyLL;

public class Node {
    int data;
    Node prev;
    Node next;

    Node (int data1, Node prev1, Node next1) {
        this.data = data1;
        this.prev = prev1;
        this.next = next1;
    }
    Node (int data1) {
        this.data = data1;
        this.prev = null;
        this.next = null;
    }
}
