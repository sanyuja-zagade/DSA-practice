import java.util.*;

public class LongestSubarrayWithSumK {
    // BRUTE APPROACH - generate all the sub-arrays and find there sum
    // TC ~ O(N^2)
    // SC -> O(1)
    public static int SubArrayBrute(int arr[], int k) {
        int len = 0;
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];
                if (sum == k) len = Math.max(len, j-i+1);
            }
        }
        return len;
    }

    // BETTER APPROACH | OPTIMAL - for zeros & -ve numbers in array
    // TC -> O(NlogN) [for ordered Map] OR
    //    -> O(N) [for unordered Map] -> O(N^2) [Worst case - if there is lots of collision - rare]
    // SC -> O(N)
    public static int SubArrayBetter(int arr[], int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0, maxLen = 0, n = arr.length;

        for (int i=0; i<n; i++) {
            sum += arr[i];
            // if sub-array from 0 -> i has sum = k
            if (sum == k) maxLen = i+1;
            // if sum-k seen before
            int remaining = sum - k;
            if (sumMap.containsKey(remaining))
                maxLen = Math.max(maxLen, i-sumMap.get(remaining));
            // store first occurrence of sum
            if (!sumMap.containsKey(sum))
                sumMap.put(sum, i);
        }
        return maxLen;
    }

    // OPTIMAL APPROACH - using 2 pointers
    // TC -> O(2N)
    // SC -> O(1)
    public static int SubArrayOptimal(int arr[], int k) {
        long sum = arr[0];
        int maxLen = 0, i = 0, j = 0;
        while (j < arr.length) {
            while (sum > k && i <= j) {
                sum -= arr[i];
                i++;
            }

            if (sum == k) maxLen = Math.max(maxLen, j-i+1);

            j++;
            if (j < arr.length) sum += arr[j];
        }
        return maxLen;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};

//        int longestSubArray = SubArrayBrute(arr, 3);
        int longestSubArray = SubArrayBetter(arr, 6);
//        int longestSubArray = SubArrayOptimal(arr, 6);

        System.out.println(longestSubArray);
    }
}
