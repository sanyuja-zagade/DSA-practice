import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(1)
    public static boolean TwoSumBrute(int arr[], int target) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (i == j) continue;
                if (arr[i] + arr[j] == target) return true;
            }
        }
        return false;
    }

    // BETTER APPROACH - using maps | OPTIMAL - if wants to return indices
    // TC -> O(NlogN) [ordered map]
    //    -> O(N) [unordered map] -> O(N^2) [Worst case]
    // SC -> O(N)
    public static int[] TwoSumBetter(int arr[], int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int requiredNum = target - arr[i];
            if (numMap.containsKey(requiredNum)) return new int[] {numMap.get(requiredNum), i};
            numMap.put(arr[i], i);
        }
        return new int[] {-1, -1};
    }

    // OPTIMAL APPROACH - only if wants to return YES/NO
    // (for returning indices it will end up taking lots of space as need to store each ele with index in new arr[][] and sort it)
    // TC -> O(NlogN)
    // SC -> O(N) [if considered changed (sorted) array]
    public static String TwoSumOptimal(int arr[], int target) {
        Arrays.sort(arr);
        int i = 0, j = arr.length-1;
        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == target) return "YES";
            else if (sum < target) i++;
            else j--;
        }
        return "NO";
    }

    public static void main (String args[]) {
        int arr[] = {2, 6, 5, 8, 11};

//        boolean result = TwoSumBrute(arr, 14);

//        int[] result = TwoSumBetter(arr, 14);
//        for (int index : result) System.out.print(index + " ");

        String result = TwoSumOptimal(arr, 14);

        System.out.println(result);
    }
}
