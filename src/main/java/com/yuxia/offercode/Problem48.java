package com.yuxia.offercode;

public class Problem48 {
    public static void main(String[] args) {
        System.out.println(new Problem48().LastRemaining_Solution(6, 2));
    }
    public int LastRemaining_Solution(int n, int m) {
        if(n<1||m<1) return -1;
        int k = 0; int len = 0;
        int a[] = new int[n]; int start = -1;
        while (k < n) {
            start = start + 1;
            if (start == n) start = 0; // quick version
        //    start = (start + 1) % n;
            if (a[start] == -1)
                continue;
            len ++;
            if (len == m) {
                a[start] = -1;
                len = 0;
                k ++;
            }
        }
        return start;
    }
}
