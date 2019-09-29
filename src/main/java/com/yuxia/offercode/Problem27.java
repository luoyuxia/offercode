package com.yuxia.offercode;

public class Problem27 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode node = Convert(pRootOfTree, true);
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode Convert(TreeNode pRootOfTree, boolean isLeft) {
        if (pRootOfTree == null)
            return null;
        TreeNode left = Convert(pRootOfTree.left, true);
        if (left != null)
            left.right = pRootOfTree;
        pRootOfTree.left = left;
        TreeNode right = Convert(pRootOfTree.right, false);
        if (right != null)
            right.left = pRootOfTree;
        pRootOfTree.right = right;
        return isLeft ? (right != null ? right : pRootOfTree) : (left != null ? left : pRootOfTree);
    }
}
