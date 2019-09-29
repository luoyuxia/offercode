package com.yuxia.offercode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Problem66 {
    public static void main(String[] args) {
        int[] num = new int[]{2,3,4,2,6,2,5,1};
        Problem66 problem66 = new Problem66();
        ArrayList<Integer> res = problem66.maxInWindows1(num, 3);
        System.out.println(res);
    }

    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (num == null || num.length < size || size == 0)
            return arrayList;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            if (!deque.isEmpty()) {
                if (i >= deque.peekFirst() + size) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && num[deque.peekLast()] < num[i]) {
                    deque.pollLast();
                }
            }
            deque.offer(i);
            if (i >= size - 1) {
                arrayList.add(num[deque.peekFirst()]);
            }
        }
        return arrayList;
    }

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (num == null || num.length < size || size == 0)
            return arrayList;
        int max = windowsMax(num, 0, size - 1);
        arrayList.add(max);
        for (int i = 1; i <= num.length - size; i++) {
            if (max < num[i - 1 + size]) {
                arrayList.add(num[i + size - 1]);
                max = num[i - 1 + size];
            } else if (num[i - 1] != max && max >= num[i + size - 1]) {
                arrayList.add(max);
            } else {
                max = windowsMax(num, i, i + size -1);
                arrayList.add(max);
            }
        }
        return arrayList;
    }

    private int windowsMax(int[] num, int start, int end) {
        int max = Integer.MIN_VALUE;
        int i = -1;
        while (start <= end) {
            if (num[start] > max) {
                i = start;
                max = num[start];
            }
            start ++;
        }
        return max;
    }
}
