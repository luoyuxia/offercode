package com.yuxia.offercode;

public class Problem50 {
    public static void main(String[] args) {
        System.out.println(new Problem50().Add(1, -9));
    }
    public int Add(int num1,int num2) {
        if (num1 == 0) {
            return num2;
        } else if (num2 == 0) {
            return num1;
        } else {
            while (num2 != 0) {
                int s = num1 ^ num2;
                num2 = (num1 & num2) << 1;
                num1 = s;
            }
            return num1;
        }
    }
}
