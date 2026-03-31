package ImplementGetMinInStack;

import java.util.*;

// TC -> O(1)
// SC -> O(N)
public class MinStackOptimal {
    private Stack<Integer> stk;
    private int min;

    public MinStackOptimal() {
        stk = new Stack<>();
    }
    public void push(int x) {
        if (stk.isEmpty()) {
            stk.push(x);
            min = x;
        }
        else {
            if (x > min)
                stk.push(x);
            else {
                stk.push(2*x - min);
                min = x;
            }
        }
    }
    public void pop() {
        if (stk.isEmpty()) return;
        int x = stk.pop();
        if (x < min)
            min = 2*min - x;
    }
    public int top() {
        if (stk.isEmpty()) return -1;
        int x = stk.peek();
        if (x < min) return min;
        else return x;
    }
    public int getMin() {
        return min;
    }
}

class Main {
    public static void main(String[] args) {
        MinStackOptimal obj = new MinStackOptimal();
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
