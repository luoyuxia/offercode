package com.yuxia.offercode;


public class Problem4 {
    public static void main(String[] args) {
        TreeNode treeNode = new Problem4().reConstructBinaryTree(new int[]{
                1,2,4,7,3,5,6,8
        }, new int[] {
                4,7,2,1,5,3,8,6
        });
        System.out.println("sdds");
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length)
            return null;
        return reConstructBinaryTree(pre, 0, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int[] in, int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(in[left]);
        int value = pre[preStart];
        TreeNode node = new TreeNode(value);
        int median = left;
        for (; median <= right; median++) {
            if (in[median] == value)
                break;
        }
        node.left = reConstructBinaryTree(pre, preStart + 1, in, left, median-1);
        node.right = reConstructBinaryTree(pre, preStart + median - left + 1, in, median + 1, right);

        return node;
    }
}
