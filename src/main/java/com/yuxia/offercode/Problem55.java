package com.yuxia.offercode;

public class Problem55 {
    public static void main(String[] args) {
        String s = "123.45e+6";
        System.out.println(new Problem55().isNumeric(s.toCharArray()));
    }
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        int splitPos = str.length;
        for (int i = str.length - 1; i >= 0; i--) {
            char c = str[i];
            if (c == 'e' || c == 'E' || c == '.') {
                splitPos = i;
                break;
            }
        }
        if (splitPos == str.length) {
            return isDigital(str, 0, str.length - 1, true);
        }
        if (str[splitPos] == 'e' || str[splitPos] == 'E') {
            return isDigital(str, 0, splitPos, true) && isDigital(str, splitPos + 1, str.length, false);
        }
        return isDigital(str, 0, splitPos, false) && isDigital(str, splitPos + 1, str.length, false);
    }




    private boolean isDigital(char[] str, int i, int j, boolean isFloat) {
        if (i >= j)
            return false;
        if (isFloat && str[i] == '.' && str[j - 1] == '.') {
            return false;
        }
        char ch = str[i];
        int start = i;
        if (ch == '-' || ch == '+') {
            start = i + 1;
        }
        if (start == j)
            return true;
        for (; start < j; start++) {
            ch = str[start];
            if (ch == '.' && isFloat) {
                isFloat = false;
                continue;
            }
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }
}
