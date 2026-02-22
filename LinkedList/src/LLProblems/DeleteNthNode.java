// Q. Delete / remove nth node from last of a LL

package LLProblems;

public class DeleteNthNode {
    public static Node InitializeLL(int arr[]) {
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

    // BRUTE APPROACH
    // TC -> O(N + (N - n))
    //    -> O(2N) [Worst case]
    // SC -> O(1)
    public static Node DeleteNodeBrute(Node head, int n) {
        Node temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (length == n) return head.next;

        int prevIndex = length - n;
        temp = head;
        while (temp != null) {
            prevIndex--;
            if (prevIndex == 0) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static Node DeleteNodeOptimal(Node head, int n) {
        Node temp1 = head;
        Node temp2 = head;
        for (int i=1; i<=n; i++) {
            temp2 = temp2.next;
        }

        if (temp2 == null) return head.next;

        while (temp2.next != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1.next = temp1.next.next;

        return head;
    }

    public static void main(String args[]) {
        int arr[] = {1, 4, 3, 7, 5};
        Node head = InitializeLL(arr);

//        head = DeleteNodeBrute(head, 6);
        head = DeleteNodeOptimal(head, 4);

        PrintLL(head);
    }}
