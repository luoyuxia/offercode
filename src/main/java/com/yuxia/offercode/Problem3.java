package com.yuxia.offercode;

import java.util.ArrayList;
import java.util.Stack;

public class Problem3 {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        int n = 0;
        ListNode head = listNode;
        while (listNode != null) {
            n = n + 1;
            listNode = listNode.next;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>(n);
        while (head != null) {
            ans.set(--n, head.val);
            head = head.next;
        }
        return ans;
    }
}
