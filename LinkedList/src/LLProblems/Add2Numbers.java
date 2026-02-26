// Q.
// LL1: 3 -> 5 -> X             =>         5 3
// LL2: 4 -> 5 -> 9 -> 9 -> X   =>  +  9 9 5 4
//                              =>   1 0 0 0 7
// O/P => LL: 7 -> 0 -> 0 -> 0 -> 1 -> X

package LLProblems;

public class Add2Numbers {
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
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // TC -> O(max(N1, N2))
    // SC -> O(max(N1, N2)) [space is used only for storing result. Technically no space is used to solve the pb]
    public static Node AddTwoNumbers(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummyNode = new Node(-1);
        Node current = dummyNode;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int sum = carry;
            if (temp1 != null) sum += temp1.data;
            if (temp2 != null) sum += temp2.data;

            Node newNode = new Node(sum % 10);

            carry = sum / 10;

            current.next = newNode;
            current = newNode;

            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        if (carry != 0) {
            Node newNode = new Node(carry);
            current.next = newNode;
        }
        return dummyNode.next;
    }

    public static void main(String args[]) {
        int arr1[] = {3, 5};
        int arr2[] = {4, 5, 9, 9};
        Node head1 = InitializeLL(arr1);
        Node head2 = InitializeLL(arr2);

        Node sumLL = AddTwoNumbers(head1, head2);

        PrintLL(sumLL);
    }
}
