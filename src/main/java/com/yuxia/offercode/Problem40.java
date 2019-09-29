package com.yuxia.offercode;

public class Problem40 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
    }
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(1 + TreeDepth(root.left), 1 + TreeDepth(root.right));
    }
}
