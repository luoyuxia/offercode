package com.yuxia.offercode;

public class Problem14 {
    public static void main(String[] args) {
        int[] a = new int[]{2,4,6,1,3,5,7};
        new Problem14().reOrderArray(a);
        int k = 0;
    }
    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j-1] % 2 == 0 && array[j] % 2 == 1) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
}
