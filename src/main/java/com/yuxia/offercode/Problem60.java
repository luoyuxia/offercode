package com.yuxia.offercode;

public class Problem60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null)
            return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        return left != null && right != null && left.val == right.val && isSymmetrical(left.right, right.left) && isSymmetrical(left.left, right.right);
    }

}
