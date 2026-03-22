import java.util.Arrays;

public class LongestCommonPrefix {
    // TC -> O(NlogN + M)  [N = length of arr, M = minimum length of string]
    // SC -> O(1)
    public static String FindLongestCommonPrefix(String arr[]) {
        Arrays.sort(arr);
        String sFirst = arr[0];
        String sLast = arr[arr.length - 1];
        int i = 0;
        while (i < Math.min(sFirst.length(), sLast.length()) && sFirst.charAt(i) == sLast.charAt(i)) i++;
        return sFirst.substring(0, i);
    }

    public static void main(String args[]) {
        String arr[] = {"interview", "internet", "internal", "interval"};

        String longestPrefix = FindLongestCommonPrefix(arr);

        System.out.println(longestPrefix);
    }
}
