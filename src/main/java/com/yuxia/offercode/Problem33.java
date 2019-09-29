package com.yuxia.offercode;

import java.util.Arrays;

public class Problem33 {
    public static void main(String[] args) {
        System.out.println(new Problem33().PrintMinNumber(new int[]{
                3,32,321
        }));
    }
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null)
            return "";
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, (a1, a2)-> {
            String c1 = a1 + a2;
            String c2 = a2 + a1;
            return c1.compareTo(c2);
        });
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(arr).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
