package com.yuxia.offercode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem62 {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        ArrayList<ArrayList<Integer>> res = new Problem62().Print(treeNode1);
        System.out.println(res);
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null)
            return res;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(pRoot);
        nodes.add(null);
        ArrayList<Integer> lineArr = new ArrayList<>();
        res.add(lineArr);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node == null) {
                if (!nodes.isEmpty()) {
                    nodes.add(null);
                    lineArr = new ArrayList<>();
                    res.add(lineArr);
                }
            } else {
                lineArr.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
        return res;
    }
}
