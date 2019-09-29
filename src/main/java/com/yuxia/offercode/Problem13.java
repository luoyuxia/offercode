package com.yuxia.offercode;

public class Problem13 {
    public static void main(String[] args) {
        System.out.println(new Problem13().Power(2, -3));
    }

    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = exponent < 0 ;
        double ans = Power(base, Math.abs(exponent) / 2);
        ans = exponent % 2 == 0 ? ans * ans : ans * ans * base;
        return isNegative ? 1 / ans : ans;
    }
}
