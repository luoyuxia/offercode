package com.yuxia.offercode;

public class Problem41 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return balanced_height(root) != -1;
    }

    private int balanced_height(TreeNode root) {
        if (root == null)
            return 0;
        int left = balanced_height(root.left);
        if (left == -1)
            return -1;
        int right = balanced_height(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) <= 1)
            return Math.max(left, right) + 1;
        return -1;
    }
}
