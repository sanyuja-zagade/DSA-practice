// Q. Return the maximum sum of a sub-array of given array

public class KadaneAlgo {
    // BRUTE APPROACH
    // TC -> O(N^3)
    // SC -> O(1)
    public static int MaxSubArraySumBrute(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                int sum = 0;
                for (int k=i; k<j; k++) {
                    sum += arr[k];
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }

    // BETTER APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static int MaxSubArraySumBetter(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++) {
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    // OPTIMAL APPROACH - Kadane's Algorithm
    // TC -> O(N^2)
    // SC -> O(1)
    public static int MaxSubArraySumOptimal(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, start = 0, startIndex = -1, endIndex = -1;
        for (int i=0; i<arr.length; i++) {
            if (sum == 0)       // to keep track of sub-array (can be skipped)
                start = i;

            sum += arr[i];

            if (sum > maxSum) {
                maxSum = sum;
                startIndex = start;     // to keep track of sub-array (can be skipped)
                endIndex = i;           // to keep track of sub-array (can be skipped)
            }

            if (sum < 0)
                sum = 0;
        }

        for (int i=startIndex; i<=endIndex; i++) {      // to print sub-array (can be skipped)
            System.out.print(arr[i] + " ");
        }

        return maxSum;
    }

    public static void main (String args[]) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};

//        int maximunSum = MaxSubArraySumBrute(arr);
//        int maximunSum = MaxSubArraySumBetter(arr);
        int maximunSum = MaxSubArraySumOptimal(arr);

        System.out.println(maximunSum);
    }
}
