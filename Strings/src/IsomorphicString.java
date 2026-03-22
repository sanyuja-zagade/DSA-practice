// Isomorphic - if characters in s1 can be replaced to get s2

import java.util.HashMap;

public class IsomorphicString {
    // TC -> O(N)
    // SC -> O(1) [space used by temp arrays is constant]
    public static boolean IsIsomorphic(String s1, String s2) {
        int[] temp1 = new int[256], temp2 = new int[256];
        for (int i=0; i< s1.length(); i++) {
            if (temp1[s1.charAt(i)] != temp2[s2.charAt(i)]) return false;
            temp1[s1.charAt(i)] = i + 1;
            temp2[s2.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String args[]) {
        String s1 = "paper", s2 = "title";

        System.out.println(IsIsomorphic(s1, s2));
    }
}
