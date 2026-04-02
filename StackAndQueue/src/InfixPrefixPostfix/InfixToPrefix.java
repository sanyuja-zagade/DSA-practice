// Step 1: Reverse infix string
// Step 2: Change '(' to ')' and vice versa
// Step 3: Convert reversed infix string to Postfix
// Step 4: Reverse the Postfix String

package InfixPrefixPostfix;

import java.util.Stack;

// TC -> O(N)
// SC -> O(N)
public class InfixToPrefix {
    public static int Precedence(char c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        return -1;
    }
    public static String InfixToPostfixConvertor(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) result.append(ch);
            else if (ch == '(') stk.push(ch);
            else if (ch == ')') {
                while (stk.peek() != '(') result.append(stk.pop());
                stk.pop();
            }
            else {
                if (ch == '^') {
                    while (!stk.isEmpty() && Precedence(ch) < Precedence(stk.peek()))
                        result.append(stk.pop());
                    stk.push(ch);
                }
                else {
                    while (!stk.isEmpty() && Precedence(ch) <= Precedence(stk.peek()))
                        result.append(stk.pop());
                    stk.push(ch);
                }
            }
        }
        while (!stk.isEmpty()) result.append(stk.pop());
        return result.toString();
    }

    public static String InfixToPrefixConversion(String s) {
        StringBuilder sCopy = new StringBuilder(s);
        sCopy.reverse();                          // O(N)
        for (int i=0; i<sCopy.length(); i++) {    // O(N)
            if (sCopy.charAt(i) == '(')
                sCopy.setCharAt(i, ')');
            else if (sCopy.charAt(i) == ')')
                sCopy.setCharAt(i, '(');
        }
        String postfix = InfixToPostfixConvertor(sCopy.toString());  // O(2N)
        return new StringBuilder(postfix).reverse().toString();      // O(N)
    }

    public static void main(String[] args) {
        String s = "a^b^c";

        System.out.println(InfixToPrefixConversion(s));
    }
}
