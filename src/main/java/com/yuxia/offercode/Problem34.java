package com.yuxia.offercode;

public class Problem34 {
    public static void main(String[] args) {
        System.out.println(new Problem34().GetUglyNumber_Solution(6));
    }
    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        int[] ans = new int[index];
        ans[0] = 1;
        int p1 = 0; int p2 = 0; int p3 = 0;
        for (int i = 1; i < index;i++) {
            ans[i] = Math.min(ans[p1] * 2, Math.min(ans[p2] * 3, ans[p3] * 5));
            if (ans[i] == ans[p1] * 2) p1 ++;
            if (ans[i] == ans[p2] * 3) p2 ++;
            if (ans[i] == ans[p3] * 5) p3 ++;
        }
        return ans[index - 1];
    }
}
