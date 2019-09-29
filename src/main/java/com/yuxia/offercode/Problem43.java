package com.yuxia.offercode;

import java.util.ArrayList;

public class Problem43 {
    public static void main(String[] args) {
        System.out.println(new Problem43().FindContinuousSequence(5));
    }
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int low = 1; int high = 2;
        while (high > low) {
            int s = (high + low) * (high - low + 1) / 2;
            if (s == sum) {
                ArrayList<Integer> l = new ArrayList<>();
                for (int k = low; k <= high; k++) {
                    l.add(k);
                }
                ans.add(l);
                low = low + 1;
            } else if (s > sum) {
                low += 1;
            } else {
                high += 1;
            }
        }
        return ans;
    }
}
