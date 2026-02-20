// Q. Find all pairs with the given Sum in a sorted DLL

package DLLProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairsOfSum {
    public static Node InitializeDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i], mover, null);
            mover.next = temp;
            mover = mover.next;
        }
        return head;
    }

    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static List<List<Integer>> FindPairsBrute(Node head, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();
        Node temp1 = head;
        while (temp1.next != null) {
            Node temp2 = temp1.next;
            while (temp2 != null && temp1.data + temp2.data <= sum) {   // ~ O(N)
                if (temp1.data + temp2.data == sum)
                    pairs.add(Arrays.asList(temp1.data, temp2.data));
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return pairs;
    }

    // OPTIMAL APPROACH
    // TC -> O(2N)
    // SC -> O(1)
    public static List<List<Integer>> FindPairsOptimal(Node head, int sum) {
        List<List<Integer>> pairs = new ArrayList<>();
        Node start = head;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        while (start.prev != last) {
            if (start.data + last.data == sum) {
                pairs.add(Arrays.asList(start.data, last.data));
                start = start.next;
                last = last.prev;
            }
            else if (start.data + last.data > sum) {
                last = last.prev;
            }
            else {
                start = start.next;
            }
        }
        return pairs;
    }

    public static void main(String agrs[]) {
        int arr[] = {1, 2, 3, 4, 9};
        Node head = InitializeDLL(arr);

//        List<List<Integer>> allPairs = FindPairsBrute(head, 5);
        List<List<Integer>> allPairs = FindPairsOptimal(head, 5);

        System.out.print(allPairs);
    }
}
