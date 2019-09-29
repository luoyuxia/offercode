package com.yuxia.offercode;

public class Problem53 {
    public static void main(String[] args) {
        System.out.println(new Problem53().multiply1(new int[]{1, 4, 5, 6, 8, 10}));
    }

    public int[] multiply1(int[] A) {
        if (A == null)
            return new int[]{};
        int n = A.length;
        int res = 1;
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            B[i] = res;
            res *= A[i];
        }
        res = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] = B[i] * res;
            res *= A[i];
        }
        return B;
    }

    public int[] multiply(int[] A) {
        if (A == null)
            return new int[]{};
        int n = A.length;
        int[] B = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = A[0];
        R[n - 1] = A[n-1];
        for (int i = 1; i < n - 1; i++) {
            L[i] = L[i - 1] * A[i];
            R[n - i - 1] = R[n - i] * A[n - i - 1];
        }
        for (int i = 0; i < n; i++) {
            int s = 1;
            if (i > 0) {
                s *= L[i - 1];
            }
            if (i < n - 1) {
                s *= R[i + 1];
            }
            B[i] = s;
        }
        return B;
    }
}
