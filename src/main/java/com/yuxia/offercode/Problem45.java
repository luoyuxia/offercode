package com.yuxia.offercode;

public class Problem45 {
    public static void main(String[] args) {
        System.out.println(new Problem45().LeftRotateString("abcXYZdef", 3));
    }
    public String LeftRotateString(String str,int n) {
        if (str == null || str.isEmpty()) return str;
        char[] arr = str.toCharArray();
        int len = str.length(); n = n % len;
        for (int i = 0, j = len - 1; i <= j; i++, j--) swap(arr, i, j);
        for (int i = 0, j = len - n - 1; i <= j; i++, j--) swap(arr, i, j);
        for (int i = len - n, j = len - 1; i <= j; i++, j--) swap(arr, i, j);
        return new String(arr);
    }
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
