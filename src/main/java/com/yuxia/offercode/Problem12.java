package com.yuxia.offercode;

public class Problem12 {
    public static void main(String[] args) {
        System.out.println(new Problem12().NumberOf1(-2
        ));
    }

    public int NumberOf1(int n) {
        boolean positive = n >= 0;
        n = positive ? -n : n;
        int[] a = new int[32];
        for (int i = 0; i < 31; i++) {
            a[i] = Math.abs(n % 2);
            n = n / 2;
        }
        if (!positive) {
            for (int i = 0; i < 32; i++) {
                a[i] = 1 - a[i];
            }
            a[0] += 1;
            int carry = 0;
            if (a[0] == 2) {
                a[0] = 0;carry = 1;
            }
            int i = 1;
            while (carry != 0 && i < 31) {
                a[i] += carry;
                carry = 0;
                if (a[i] == 2) {
                    a[i++] = 0;
                    carry = 1;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (a[i] == 1)
                ans += 1;
        }
        return ans;
    }
}
