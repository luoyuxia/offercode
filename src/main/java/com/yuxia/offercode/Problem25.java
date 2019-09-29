package com.yuxia.offercode;

import java.util.*;

public class Problem25 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        Map<Integer, ArrayList<Integer>> ans = new TreeMap<Integer, ArrayList<Integer>>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        FindPath(root, target, new ArrayList<Integer>(), ans);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : ans.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private void FindPath(TreeNode root, int target, ArrayList<Integer> integers, Map<Integer, ArrayList<Integer>> ans) {
        if (root == null && target == 0)
            if (integers.size() > 0)
                ans.put(integers.size(), new ArrayList<Integer>(integers));
        if (root == null)
            return;
        integers.add(root.val);
        FindPath(root.left, target - root.val, integers, ans);
        FindPath(root.right, target - root.val, integers, ans);
        integers.remove(integers.size() - 1);
    }
}
