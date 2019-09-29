package com.yuxia.offercode;

import java.util.Stack;

public class Problem22 {
    public static void main(String[] args) {
        System.out.println(new Problem22().IsPopOrder(new int[]{1,2,3,4,5},
                new int[]{4,5,3,2,1}));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int j = 0;
        while (j < popA.length) {
            int value = popA[j];
            if (!stack.isEmpty() && stack.peek() == value) {
                stack.pop();
            } else {
                while (i < pushA.length && pushA[i] != value) {
                    stack.push(pushA[i]);
                    i ++ ;
                }
                if (i >= pushA.length)
                    return false;
                i = i + 1;
            }
            j ++;
        }
        return i == pushA.length && j == popA.length;
    }
}
