import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ReverseWords {
    // BRUTE APPROACH
    // TC -> O(N)
    // SC -> O(N)
    public static String ReverseWordsBrute(String s) {
        ArrayList<String> wordsList = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != ' ')
                word.append(s.charAt(i));
            else if (word.length() > 0) {
                wordsList.add(word.toString());
                word.setLength(0);
            }
        }
        if (word.length() > 0)
            wordsList.add(word.toString());

        Collections.reverse(wordsList);

        return String.join(" ", wordsList);
    }

    // OPTIMAL APPROACH
    // TC -> O(N)
    // SC -> O(1)
    public static String ReverseWordsOptimal(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;
            if (i < 0) break;
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            String word = s.substring(i+1, end+1);
            if (result.length() > 0) result.append(" ");
            result.append(word);
        }
        return result.toString();
    }

    public static void main(String args[]) {
        String s = "Tom & Jerry 2";

//        System.out.println(ReverseWordsBrute(s));
        System.out.println(ReverseWordsOptimal(s));
    }
}
