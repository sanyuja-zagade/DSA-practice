import java.util.Stack;

public class CheckBalancedParenthesis {
    // TC -> O(N)
    // SC -> O(N)
    public static boolean BalancedParenthesisCheck(String str) {
        Stack<Character> stk = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{')
                stk.push(ch);
            else {
                if (stk.isEmpty()) return false;
                char top = stk.pop();
                if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {}
                else
                    return false;
            }
        }
        return (stk.isEmpty());
    }

    public static void main(String[] args) {
        String str = "()[(){}(])";

        System.out.println(BalancedParenthesisCheck(str));
    }
}
