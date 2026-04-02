package InfixPrefixPostfix;

import java.util.Stack;

public class PostfixToInfix {
    // TC -> O(N)+O(N) ~ O(N)
    // SC -> O(N)
    public static String PostfixToInfixConvertor(String s) {
        Stack<String> stk = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) stk.push(String.valueOf(ch));
            else {
                String top1 = stk.pop();
                String top2 = stk.pop();
                String newStr = '(' + top2 + ch + top1 + ')';  // O(N1 + N2) [N1, N2 = lengths of top1, top2]
                stk.push(newStr);                              // [O(N) -> Worst case - to concatenate last two strings]
            }
        }
        return stk.peek();
    }

    public static void main(String[] args) {
        String s = "AB*C+";

        System.out.println(PostfixToInfixConvertor(s));
    }
}
