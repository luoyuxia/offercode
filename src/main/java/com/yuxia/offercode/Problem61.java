package com.yuxia.offercode;

import java.util.*;

public class Problem61 {
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
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode4;
        treeNode3.left = treeNode5;
        ArrayList<ArrayList<Integer>> res = new Problem61().Print(treeNode1);
        System.out.println(res);
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null)
            return result;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(pRoot);
        int start = 0;
        int end = 1;
        int iter = 0;
        while (start != end) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = start; i < end; i++) {
                if (iter % 2 == 0) {
                    arr.add(treeNodes.get(i).val);
                } else {
                    arr.add(treeNodes.get(end - (i - start) - 1).val);
                }
                TreeNode node = treeNodes.get(i);
                if (node.left != null) {
                    treeNodes.add(node.left);
                }
                if (node.right != null) {
                    treeNodes.add(node.right);
                }
            }
            start = end;
            end = treeNodes.size();
            result.add(arr);
            iter ++ ;
        }
        return result;
    }
}
