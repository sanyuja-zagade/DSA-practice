import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(N) [space used for returning purpose, to store the ans]
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
        }
        return ans;
    }

    // OPTIMAL APPROACH
    // TC -> O(2N)
    // SC -> O(N) + O(N) [stack, ans[]]
    public static int[] NextGreaterElementOptimal(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for (int i=arr.length-1; i>=0; i--) {
            while (!stk.isEmpty() && stk.peek() <= arr[i]) stk.pop();   // O(N) [Worst Case]
            if (stk.isEmpty()) ans[i] = -1;
            else ans[i] = stk.peek();
            stk.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10};

//        int[] ans = NextGreaterElementBrute(arr);
        int[] ans = NextGreaterElementOptimal(arr);

        for (int ele : ans) System.out.print(ele + " ");
    }
}
