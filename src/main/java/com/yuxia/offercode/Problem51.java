package com.yuxia.offercode;

public class Problem51 {
    public static void main(String[] args) {
        System.out.println(new Problem51().StrToInt("+1a33"));
    }
    public int StrToInt(String str) {
        if (str == null || str.equals(""))
            return 0;
        char firstChar = str.charAt(0);
        if (firstChar != '-' && firstChar != '+' && !(firstChar >= '0' && firstChar <= '9')) {
            return 0;
        }
        boolean isPositive = true;
        int result = 0;
        int start = 0;
        if (firstChar == '-') {
            isPositive = false;
            start += 1;
        } else if (firstChar == '+') {
            start += 1;
        }
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return 0;
            }
            int digital = str.charAt(i) - '0';
            if (isPositive && result > (Integer.MAX_VALUE - digital) / 10.0) {
                return 0;
            }
            if (!isPositive && result > (Integer.MIN_VALUE + digital) / -10.0) {
                return 0;
            }
            result = result * 10 + digital;
        }
        return isPositive ? result : -result;
    }
}
