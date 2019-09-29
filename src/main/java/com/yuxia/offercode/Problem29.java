package com.yuxia.offercode;

public class Problem29 {
    public static void main(String[] args) {
        System.out.println(new Problem29().MoreThanHalfNum_Solution(new int[]{
                1,2,3,2,2,2,5,4,2
        }));
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int half = array.length / 2;
        int ans = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == ans) {
                count ++;
            } else {
                count --;
            }
            if (count == 0) {
                ans = array[i];
                count = 1;
            }
        }
        int total = 0;
        for (int v : array) {
            if (v == ans)
                total += 1;
        }
        return total > half ? ans : 0;
    }
}
