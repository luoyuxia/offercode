package com.yuxia.offercode;

public class Problem16 {
    public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    }
    public ListNode ReverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }

}
