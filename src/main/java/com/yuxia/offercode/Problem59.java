package com.yuxia.offercode;

public class Problem59 {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if (pNode == null)
            return null;
        if (pNode.right == null) {
            while (pNode.next != null && pNode.next.right == pNode) {
                pNode = pNode.next;
            }
            return pNode.next;
        }
        TreeLinkNode p = pNode.right;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }
}
