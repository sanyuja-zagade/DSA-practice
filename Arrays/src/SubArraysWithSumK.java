// Q. Return the number of sub-arrays with sum K

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumK {
    // BRUTE APPROACH
    // TC -> O(N^3)
    // SC -> O(1)
    public static int SubArraysBrute(int arr[], int k) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr.length; j++) {
                int sum = 0;
                for (int q=i; q<=j; q++) {
                    sum += arr[q];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    // BETTER APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static int SubArraysBetter(int arr[], int k) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];
                if (sum == k) count++;
            }
        }
        return count;
    }

    // OPTIMAL APPROACH
    // TC -> O(N * LogN) [ordered map]
    //    -> O(N * 1) [unordered map] | O(N * N) [Worst case] [unordered map]
    // SC -> O(N) [Worst case]
    public static int SubArraysOptimal(int arr[], int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);

        for (int i=0; i<arr.length; i++) {
            sum += arr[i];

            int remove = sum - k;
            if(mpp.containsKey(remove))
                count += mpp.get(remove);

            mpp.put(sum, mpp.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};

//        int totalSubArrays = SubArraysBrute(arr, 3);
//        int totalSubArrays = SubArraysBetter(arr, 3);
        int totalSubArrays = SubArraysOptimal(arr, 3);

        System.out.println(totalSubArrays);
    }
}
