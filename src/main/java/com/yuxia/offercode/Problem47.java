package com.yuxia.offercode;

import java.util.Arrays;

public class Problem47 {
    public static void main(String[] args) {
        System.out.println(new Problem47().isContinuous(new int[]{1}));
    }
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        int[] d = new int[14];
        d[0] = -5; int min = 14; int max = -1;
        for (int number : numbers) {
            if (number == 0)
                continue;
            if (d[number] == 1)
                return false;
            d[number] += 1;
            if (number > max) max = number;
            if (number < min) min = number;
        }
        return max - min < 5;
    }
}
