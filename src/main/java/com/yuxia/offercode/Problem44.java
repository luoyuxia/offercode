package com.yuxia.offercode;
import java.util.ArrayList;
public class Problem44 {
    public static void main(String[] args) {
        System.out.println(new Problem44().FindNumbersWithSum(new int[]{1, 2, 8, 9}, 10));
    }
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        if (array == null || array.length < 2) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int left = 0; int right = array.length - 1;
        while (left <= right) {
            int result = array[left] + array[right];
            if (result == sum) {
                ans.add(array[left]); ans.add(array[right]);
                return ans;
            } else if (result > sum) {
                right --;
            } else {
                left ++;
            }
        }
        return ans;
    }
}
