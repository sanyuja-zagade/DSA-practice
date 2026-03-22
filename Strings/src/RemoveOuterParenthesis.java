public class RemoveOuterParenthesis {
    // TC -> O(N)
    // SC -> O(N) [Auxiliary space complexity]
    public static String RemoveParenthesis(String s) {
        StringBuilder result = new StringBuilder();
        int level = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (level > 0) result.append(ch);
                level++;
            }
            else if (ch == ')') {
                level--;
                if (level > 0) result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String args[]) {
        String s = "()(()())(())";

        System.out.println(RemoveParenthesis(s));
    }
}
