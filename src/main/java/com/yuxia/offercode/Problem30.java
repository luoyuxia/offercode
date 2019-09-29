package com.yuxia.offercode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem30 {
    public static void main(String[] args) {
        System.out.println(new Problem30().GetLeastNumbers_Solution1(new int[]{
                4,5,1,6,2,7,3,8
        }, 8));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0)
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        GetLeastNumbers_Solution(ans, input, 0, input.length - 1, k);
        Collections.sort(ans);
        return ans;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        if (input == null || input.length == 0 || k > input.length)
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++)
            priorityQueue.offer(input[i]);
        for (int i = k; i < input.length; i++) {
            int v = input[i];
            if (v < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(v);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ans.add(priorityQueue.poll());
        }
        return ans;
    }

    private void GetLeastNumbers_Solution(ArrayList<Integer> ans, int[] input, int left, int right, int k) {
        if (k <= 0 || k > (right - left + 1))
            return;
        int pivot = input[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && input[j] >= pivot)
                j --;
            while (i < j && input[i] <= pivot)
                i ++;
            if (i < j)
                swap(input, i, j);
        }
        swap(input, left, i);
        int n = i - left + 1;
        if (n > k)
            GetLeastNumbers_Solution(ans, input, left, i, k);
        else {
            for (int m = left; m <= i; m++) {
                ans.add(input[m]);
            }
            GetLeastNumbers_Solution(ans, input, i + 1, right, k - i + left - 1);
        }
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

}
