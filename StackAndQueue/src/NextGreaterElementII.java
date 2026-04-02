// Q. Find the next greater element in a circular array

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(N) [space is used for returning purpose, to store the ans]
    public static int[] NextGreaterElementBrute(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] > arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
            if (ans[i] == -1) {
                for (int j=0; j<i; j++) {
                    if (arr[j] > arr[i]) {
                        ans[i] = arr[j];
                        break;
                    }
                }
            }
        }
        return ans;
    }

    // BETTER APPROACH
    // TC -> O(N^2)
    // SC -> O(N) [space is used for returning purpose, to store the ans]
    public static int[] NextGreaterElementBetter(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<i+(arr.length-1); j++) {  // Hypothetically doubling the arr
                int index = j % arr.length;
                if (arr[index] > arr[i]) {
                    ans[i] = arr[index];
                    break;
                }
            }
        }
        return ans;
    }

    // OPTICAL APPROACH
    // TC -> O(4N)
    // SC -> O(2N) + O(N) [stack, ans[]]
    public static int[] NextGreaterElementOptimal(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i=2*n-1; i>=0; i--) {  // O(2N)
            while (!stk.isEmpty() && stk.peek() <= arr[i % n]) stk.pop();   // O(2N) [at max]
            if (i < n) {
                if (stk.isEmpty()) ans[i] = -1;
                else ans[i] = stk.peek();
            }
            stk.push(arr[i % n]);   // O(2N) [at max]
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 10, 12, 1, 11};

//        int[] ans = NextGreaterElementBrute(arr);
//        int[] ans = NextGreaterElementBetter(arr);
        int[] ans = NextGreaterElementOptimal(arr);

        for (int ele : ans) System.out.print(ele + " ");
    }
}
