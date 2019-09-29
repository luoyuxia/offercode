package com.yuxia.offercode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem63 {
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
        treeNode2.left = treeNode3;
        treeNode3.left = treeNode4;
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.right = treeNode4;
//        treeNode3.left = treeNode5;
//        treeNode3.right = treeNode6;
        Problem63 p = new Problem63();
        String serializeStr = p.Serialize(treeNode1);
        System.out.println(serializeStr);
        TreeNode root = p.Deserialize(serializeStr);
        System.out.println(root);
    }

    String Serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                stringBuilder.append("#!");
            } else {
                stringBuilder.append(node.val).append('!');
                if (node.left != null || node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return stringBuilder.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0)
            return null;
        String[] values = str.split("[!]");
        if (values.length == 0)
            return null;
        TreeNode node = new TreeNode(Integer.valueOf(values[0]));
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(node);
        int i = 1;
        int start = 0;
        while (i < values.length) {
            int n = treeNodes.size();
            for (int k = start; k < n; k++) {
                node = treeNodes.get(k);
                if (node != null) {
                    node.left = values[i].equals("#") ? null : new TreeNode(Integer.valueOf(values[i]));
                    node.right = values[i + 1].equals("#") ? null : new TreeNode(Integer.valueOf(values[i + 1]));
                    i = i + 2;
                    treeNodes.add(node.left);
                    treeNodes.add(node.right);
                }
            }
            start = n;
        }
        return treeNodes.get(0);
    }
}
