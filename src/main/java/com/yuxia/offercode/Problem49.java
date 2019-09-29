package com.yuxia.offercode;

public class Problem49 {
    public static void main(String[] args) {
        System.out.println(new Problem49().Sum_Solution(4));
    }
    public int Sum_Solution(int n) {
        int sum = n;
        boolean np = (n > 0) && ((sum = Sum_Solution(n-1) + n) == 1);
        return sum;
    }
}
