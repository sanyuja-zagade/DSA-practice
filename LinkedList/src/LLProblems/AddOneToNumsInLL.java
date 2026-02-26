// Q.
// LL: 1 -> 5 -> 9 -> X     => 159 + 1 = 160
// O/P => LL: 1 -> 6 -> 0 -> X

package LLProblems;

public class AddOneToNumsInLL {
    public static Node InitializeLL(int arr[]) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node mover  = head;
        for (int i=1; i<arr.length; i++) {
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

    // ITERATIVE APPROACH
    // TC -> O(3N)
    // SC -> O(1)
    public static Node ReverseLL(Node head) {
        if (head == null || head.next == null) return head;
        Node newHead = ReverseLL(head.next);
        Node nextNode = head.next;
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
    public static Node AddOneToNumber(Node head) {
        head = ReverseLL(head);
        Node current = head;
        int carry = 1;
        while (current != null && carry > 0) {
            int sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;

            if (current.next == null && carry > 0) {
                current.next = new Node(carry);
                carry = 0;
            }

            current = current.next;
        }
        head = ReverseLL(head);
        return head;
    }

    // RECURSIVE METHOD
    // TC -> O(N)
    // SC -> O(N) [recursive stack space]
    public static int Helper(Node temp) {
        if (temp == null) return 1;
        int carry = Helper(temp.next);
        temp.data += carry;
        if (temp.data < 10) return 0;
        temp.data = 0;
        return 1;
    }
   public static Node AddOneToNumberRecursive(Node head) {
        int carry = Helper(head);
        if (carry == 1) {
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
   }

    public static void main(String args[]) {
        int arr[] = {9, 9, 9};
        Node head = InitializeLL(arr);

//        Node modifiedLL = AddOneToNumber(head);
        Node modifiedLL = AddOneToNumberRecursive(head);

        PrintLL(modifiedLL);
    }
}
