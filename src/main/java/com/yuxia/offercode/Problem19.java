package com.yuxia.offercode;

public class Problem19 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public void Mirror(TreeNode root) {
        if (root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

}
