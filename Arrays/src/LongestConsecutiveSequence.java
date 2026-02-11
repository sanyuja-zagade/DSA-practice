import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static boolean LinearSearch(int arr[], int ele) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == ele)
                return true;
        }
        return false;
    }
    public static int longestSequenceBrute(int arr[]) {
        int longestLength = 1;
        for (int i=0; i<arr.length; i++) {
            int currEle = arr[i], count = 1;
            while (LinearSearch(arr, currEle+1)) {
                currEle++; count++;
            }
            longestLength = Math.max(longestLength, count);
        }
        return longestLength;
    }

    // BETTER APPROACH
    // TC -> O(N)
    //    -> O(NlogN) [if array is not sorted, it needs to be sorted]
    // SC -> O(1)
    public static int longestSequenceBetter(int arr[]) {
        int longestLength = 1, count = 0, lastSmallerEle = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            if (arr[i]-1 == lastSmallerEle) {
                count++;
                lastSmallerEle = arr[i];
            }
            else if (arr[i] != lastSmallerEle) {
                count = 1;
                lastSmallerEle = arr[i];
            }
            longestLength = Math.max(longestLength, count);
        }

        return longestLength;
    }

    // OPTIMAL APPROACH
    // TC -> O(3N) ~ O(N)
    // SC -> O(N) [Worst case]
    public static int longestSequenceOptimal(int arr[]) {
        if (arr.length == 0)
            return 0;

        int longestLength = 1;
        Set<Integer> st = new HashSet<>();

        for (int i=0; i<arr.length; i++) {      // TC -> O(N)
            st.add(arr[i]);
        }
        for (int ele : st) {                    // TC -> O(N) + O(N) ~ O(2N)
            if (!st.contains(ele - 1)) {
                int count = 1;
                int currEle = ele;

                while (st.contains(currEle + 1)) {  // this loop runs only from smallest ele in sequence; that's why ~ O(N)
                    currEle = currEle + 1;
                    count++;
                }
                longestLength = Math.max(longestLength, count);
            }
        }

        return longestLength;
    }

    public static void main(String args[]) {
        int arr[] = {102, 4, 100, 1, 101, 3, 2, 1, 1};
        int arr2[] = {1, 1, 1, 2, 2, 2, 3, 3, 4, 100, 100, 101, 101, 102};

//        int longestSequenceLength = longestSequenceBrute(arr);
//        int longestSequenceLength = longestSequenceBetter(arr2);
        int longestSequenceLength = longestSequenceOptimal(arr);

        System.out.println(longestSequenceLength);
    }
}
