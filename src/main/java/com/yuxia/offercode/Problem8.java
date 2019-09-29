package com.yuxia.offercode;

public class Problem8 {
    public static void main(String[] args) {
        System.out.println(new Problem8().Fibonacci(5));
    }
    public int Fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        int a1 = 1; int a2 = 1;
        for (int i = 0; i < n - 2; i++) {
            int temp = a1 + a2;
            a1 = a2;
            a2 = temp;
        }
        return a2;
    }
}
