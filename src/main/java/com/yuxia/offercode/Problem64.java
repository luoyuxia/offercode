package com.yuxia.offercode;

import java.util.Stack;

public class Problem64 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(8);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        TreeNode node = new Problem64().KthNode1(treeNode1, 2);
        System.out.println(node.val);
    }

    TreeNode KthNode1(TreeNode pRoot, int k) {
        if (pRoot == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (--k == 0)
                return p;
            p = p.right;
        }
        return null;
    }

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if (pRoot == null)
            return null;
        int leftN = nodeCount(pRoot.left);
        if (leftN == k - 1)
            return pRoot;
        else if (leftN > k - 1)
            return KthNode(pRoot.left, k);
        else
            return KthNode(pRoot.right, k - leftN - 1);
    }

    int nodeCount(TreeNode pRoot) {
        if (pRoot == null)
            return 0;
        return 1 + nodeCount(pRoot.left) + nodeCount(pRoot.right);
    }
}
