package com.yuxia.offercode;

public class Problem31 {
    public static void main(String[] args) {
        System.out.println(new Problem31().FindGreatestSumOfSubArray(new int[]{
                6,-3,-2,7,-15,1,2,2
        }));
    }
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int n = array.length;
        int ans = array[0];
        int temp = array[0];
        for (int i = 1; i < n; i++) {
            temp = Math.max(temp + array[i], array[i]);
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}
