package com.yuxia.offercode;

public class Problem52 {
    public static void main(String[] args) {
        System.out.println(new Problem52().duplicate1(new int[]{2,3,1,0,2,5,3}, 7, new int[]{1}));
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null)
            return false;
        int[] cache = new int[length];
        for (int number : numbers) {
            if (cache[number] == 0) {
                cache[number] = 1;
            } else {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }

    public boolean duplicate1(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length == 0)
            return false;
        for (int i = 0; i < length; i++) {
            int m = numbers[i];
            while (m != i) {
                if (m == numbers[m]) {
                    duplication[0] = m;
                    return true;
                }
                swap(numbers, i, m);
                m = numbers[i];
            }
        }
        return false;
    }

    public void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
