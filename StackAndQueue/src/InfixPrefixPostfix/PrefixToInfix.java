package InfixPrefixPostfix;

import java.util.Stack;

public class PrefixToInfix {
    // TC -> O(N)+O(N) ~ O(N)
    // SC -> O(N)
    public static String PrefixToInfixConvertor(String s) {
        Stack<String> stk = new Stack<>();
        for (int i=s.length()-1; i>=0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) stk.push(String.valueOf(ch));
            else {
                String top1 = stk.pop();
                String top2 = stk.pop();
                String newStr = '(' + top1 + ch + top2 + ')';   // O(N1 + N2) [N1, N2 = lengths of top1, top2]
                stk.push(newStr);                               // O(N) [Worst Case - to concatenate last two strings]
            }
        }
        return stk.peek();
    }

    public static void main(String[] args) {
        String s = "*+PQ-MN";

        System.out.println(PrefixToInfixConvertor(s));
    }
}
