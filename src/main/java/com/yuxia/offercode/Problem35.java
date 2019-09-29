package com.yuxia.offercode;

public class Problem35 {
    public static void main(String[] args) {
        System.out.println(new Problem35().FirstNotRepeatingChar("google"));
    }
    public int FirstNotRepeatingChar(String str) {
        int[] arr = new int[26 * 2];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c >= 'A' && c <='Z' ? c - 'A' : c - 'a' + 26;
            arr[index] += 1;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = c >= 'A' && c <= 'Z' ? c - 'A' : c - 'a' + 26;
            if (arr[index] == 1)
                return i;
        }
        return -1;
    }
}
