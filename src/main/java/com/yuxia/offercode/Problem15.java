package com.yuxia.offercode;

public class Problem15 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode ans = null;
        ListNode first = null;
        for (int i = 0; i < k; i++) {
            if (first == null)
                first = head;
            else
                first = first.next;
            if (first == null)
                break;
        }
        while (first!=null) {
            if (ans == null)
                ans = head;
            else
                ans = ans.next;
            first = first.next;
        }
        return ans;
    }
}
