package com.yuxia.offercode;

public class Problem39 {
    public static void main(String[] args) {
        System.out.println(new Problem39().GetNumberOfK(new int[]{
                1, 2, 3, 4,4, 5
        }, 4));
    }
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > k)
                return count;
            if (array[i] == k)
                count ++;
        }
        return count;
    }
}
