package com.yuxia.offercode;

public class Problem18 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return root2 != null && recursiveHasSubtree(root1, root2);
    }

    private boolean recursiveHasSubtree(TreeNode root1, TreeNode root2) {
        return isSame(root1, root2) || (root1 != null && isSame(root1.left, root2)) || (root1 != null && isSame(root1.right, root2));
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        return root2 == null || root1 != null && root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
}
