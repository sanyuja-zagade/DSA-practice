// Q. Find an element that appears more than n/2 times in an array (n = length of array)

import java.util.HashMap;
import java.util.Map;

public class MooreVotingAlgo {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static int MajorityElementBrute(int arr[]) {
        for (int i=0; i<arr.length; i++) {
            int count = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[j] == arr[i])
                    count++;
            }
            if (count > arr.length / 2)
                return count;
        }
        return -1;
    }

    // BETTER APPROACH - Hashing
    // TC -> O(NlogN) + O(N) [Ordered map]
    // SC -> O(N)
    public static int MajorityElementBetter(int arr[]) {
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0) + 1);
        }
        for (int key : mpp.keySet()) {
            if (mpp.get(key) > arr.length / 2)
                return key;
        }

        return -1;
    }

    // OPTIMAL SOLUTION - Moore's Voting Algorithm
    // TC -> O(N)
    // SC -> O(1)
    public static int MajorityElementOptimal(int arr[]) {
        int ele = 0, count = 0;
        for (int i=0; i<arr.length; i++) {
            if (count == 0) {
                count = 1;
                ele = arr[i];
            }
            else if (arr[i] == ele) count++;
            else count--;
        }

        // below steps can be skipped if the pb states that there is always a majority ele. Just return the ele instead
        int count2 = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == ele) count2++;
        }
        if (count2 > arr.length / 2) return ele;
        return -1;
    }

    public static void main (String args[]) {
        int arr[] = {7, 7, 5, 7, 5, 1, 5, 5, 5};

//        int majorityElement = MajorityElementBrute(arr);
//        int majorityElement = MajorityElementBetter(arr);
        int majorityElement = MajorityElementOptimal(arr);

        System.out.println(majorityElement);
    }
}
