package com.yuxia.offercode;
import java.util.Stack;
public class Problem21 {
    private Stack<Integer> stack = new Stack<Integer>();
    private int min;
    public void push(int node) {
        if (stack.isEmpty()) {
            min = node;
        }
        stack.push(node - min);
        if (min >= node)
            min = node;
    }

    public void pop() {
        int top = stack.pop();
        if (top <= 0) {
            min = min - top;
        }
    }

    public int top() {
        if (stack.peek() <= 0)
            return min;
        return stack.peek() + min;
    }

    public int min() {
        if (stack.isEmpty())
            throw new IllegalArgumentException("The stack is empty!");
        return min;
    }
}
