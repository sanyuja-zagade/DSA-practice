// Q. Check if two strings are anagrams of each other
// Anagrams - all possible permutations of string

import java.util.Arrays;

public class AnagramsOfStrings {
    // BRUTE APPROACH
    // TC -> O(NlogN)
    // SC -> O(N) [two charArrays]
    public static boolean IsAnagramBrute(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] charArr1 = s1.toCharArray();     // O(N)
        char[] charArr2 = s2.toCharArray();     // O(N)
        Arrays.sort(charArr1);                  // O(NlogN)
        Arrays.sort(charArr2);                  // O(NlogN)
        for (int i=0; i<s1.length(); i++) {     // O(N)
            if (charArr1[i] != charArr2[i]) return false;
        }
        return true;
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static boolean IsAnagramOptimal(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int alphabets[] = new int[26];
        for (int i=0; i<s1.length(); i++) {
            alphabets[s1.charAt(i) - 'A']++;
        }
        for (int i=0; i<s2.length(); i++) {
            alphabets[s2.charAt(i) - 'A']--;
        }
        for (int i=0; i<26; i++) {
            if (alphabets[i] != 0) return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String s1 = "CAT", s2 = "ACT";

//        System.out.println(IsAnagramBrute(s1, s2));
        System.out.println(IsAnagramOptimal(s1, s2));
    }
}
