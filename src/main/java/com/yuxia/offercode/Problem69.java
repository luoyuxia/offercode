package com.yuxia.offercode;

public class Problem69 {
    public static void main(String[] args) {
        Problem69 problem69 = new Problem69();
        int res = problem69.cutRope1(3);
        System.out.println(res);
    }

    public int cutRope1(int target) {
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        int[] dp = new int[target + 1];
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i],  dp[i - j] * j);
            }
        }
        return dp[target];
    }

    public int cutRope(int target) {
        double max = 0;
        for (int i = 1; i < target; i++) {
            int n = target / i;
            int k = target % i;
            double sum = Math.pow(i, n);
            if (k != 0) {
                sum *= k;
            }
            if (max < sum) {
                max = sum;
            }
        }
        return (int)max;
    }
}
