package com.yuxia.offercode;

public class Problem42 {
    public static void main(String[] args) {
        int[] a1 = new int[]{1};
        int[] a2 = new int[]{2};
        new Problem42().FindNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5}, a1,a2);
        System.out.println(a1[0]);
        System.out.println(a2[0]);
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res = 0;
        for (int item : array) res = res ^ item;
        int fisrtOneIndex = 0;
        while ((res & 1) == 0) {
            fisrtOneIndex += 1;
            res = res >> 1;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int value : array) {
            if (((value >> fisrtOneIndex) & 1) == 0) {
                num1[0] = num1[0] ^ value;
            } else {
                num2[0] = num2[0] ^ value;
            }
        }
    }
}
