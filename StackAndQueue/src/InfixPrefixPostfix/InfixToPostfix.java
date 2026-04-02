// Precedence: (^) > (*,/) > (+,-)
// Associativity: (Left) : +,-,*,/
//              : (Right): ^

package InfixPrefixPostfix;

import java.util.Stack;

// TC -> O(N) + O(N)
// SC -> O(N) + O(N)  [stack, result string]
public class InfixToPostfix {
    public static int Precedence(char c) {
        if (c == '^') return 3;
        else if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        return -1;
    }

    public static String InfixToPostfixConversion(String s) {       // O(N) + O(N)
        Stack<Character> stk = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<s.length(); i++) {      // O(N)
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) result.append(ch);
            else if (ch == '(') stk.push(ch);
            else if (ch == ')') {
                while (stk.peek() != '(')       // O(N)
                    result.append(stk.pop());
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
        while (!stk.isEmpty())      // O(N)
            result.append(stk.pop());

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "(p+q)*(m-n)";

        System.out.println(InfixToPostfixConversion(s));
    }
}
