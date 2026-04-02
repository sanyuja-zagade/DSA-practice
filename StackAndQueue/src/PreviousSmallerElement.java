import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    // BRUTE APPROACH
    // TC -> O(N^2)
    // SC -> O(N)
    public static int[] PreviousSmallerElementBrute(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans, -1);
        for (int i=0; i<arr.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (arr[j] < arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }

    // OPTIMAL APPROACH
    // TC -> O(2N)
    // SC -> O(N) + O(N)
    public static int[] PreviousSmallerElementOptimal(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        for (int i=0; i<arr.length; i++) {  // O(N)
            while (!stk.isEmpty() && stk.peek() >= arr[i]) stk.pop(); // O(N)
            if (stk.isEmpty()) ans[i] = -1;
            else ans[i] = stk.peek();
            stk.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 6, 7, 4};

//        int[] ans = PreviousSmallerElementBrute(arr);
        int[] ans = PreviousSmallerElementOptimal(arr);

        for (int ele : ans) System.out.print(ele + " ");
    }
}
