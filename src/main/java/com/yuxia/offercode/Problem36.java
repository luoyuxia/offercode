package com.yuxia.offercode;

public class Problem36 {
    public static void main(String[] args) {
        System.out.println(new Problem36().InversePairs(new int[]{
                1,2,3,4,5,6,7,0
        }));
    }
    public int InversePairs(int [] array) {
        if (array == null || array.length <= 1)
            return 0;
        return mergeInversePairs(array, 0, array.length-1);
    }


    public int mergeInversePairs(int[] arr, int left, int right) {
        if (left == right)
            return 0;
        int median = (left + right) /2;
        int m1 = mergeInversePairs(arr, left, median) % 1000000007;
        int m2 = mergeInversePairs(arr, median + 1, right) % 1000000007;
        return (m1 + m2 + mergeArr(arr, left, median, right)) % 1000000007;
    }

    public int mergeArr(int[] arr, int left, int median, int right) {
        int count = 0;
        int i = left;
        int j = median + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= median && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count = (count +  (median - i + 1)) % 1000000007;
            }
        }
        while (i <= median)
            temp[k++] = arr[i++];
        while (j <= right){
            temp[k++] = arr[j++];
        }

        if (right + 1 - left >= 0) System.arraycopy(temp, 0, arr, left, right + 1 - left);
        return count;
    }
}
