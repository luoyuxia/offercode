package com.yuxia.offercode;

public class Problem6 {
    public static void main(String[] args) {
        System.out.println(new Problem6().minNumberInRotateArray(new int[]{
                1,2,3,4,5,
        }));
    }
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        return minNumberInRotateArray(array, 0, array.length - 1);
    }

    public int minNumberInRotateArray(int[] arr, int left, int right) {
        if (left == right)
            return Math.min(arr[left], arr[right]);
        int median = left + (right - left) / 2;
        if ((arr[median] >= arr[left] && arr[left] >= arr[right]))
            return minNumberInRotateArray(arr, median, right);
        else
            return minNumberInRotateArray(arr, left, median);
    }
}
