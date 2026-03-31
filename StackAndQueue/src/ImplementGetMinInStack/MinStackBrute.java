package ImplementGetMinInStack;

import java.util.*;

// TC -> O(1)
// SC -> O(2N)
public class MinStackBrute {
    private Stack<int[]> stk;

    public MinStackBrute() {
        stk = new Stack<>();
    }
    public void push(int x) {
        if (stk.isEmpty()) stk.push(new int[] {x, x});
        else {
            int min = Math.min(x, getMin());
            stk.push(new int[] {x, min});
        }
    }
    public void pop() {
        stk.pop();
    }
    public int top() {
        return stk.peek()[0];
    }
    public int getMin() {
        return stk.peek()[1];
    }


    public static void main(String[] args) {
            MinStackBrute obj = new MinStackBrute();
            obj.push(12);
            obj.push(15);
            obj.push(10);
            System.out.println(obj.getMin());
            obj.pop();
            System.out.println(obj.top());
            System.out.println(obj.getMin());
            obj.pop();
            System.out.println(obj.getMin());
    }
}