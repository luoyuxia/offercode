package com.yuxia.offercode;

public class Problem57 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        System.out.println(new Problem57().EntryNodeOfLoop(node1).val);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        int n = 0;
        ListNode p1 = null;
        ListNode p2 = null;
        do {
            if (p2 == null) {
                if (pHead != null && pHead.next != null) {
                    p2 = pHead.next;
                } else {
                    return null;
                }
            } else {
                if (p2.next != null && p2.next.next != null) {
                    p2 = p2.next.next;
                } else {
                    return null;
                }
            }
            if (p1 == null) {
                p1 = pHead;
            } else {
                p1 = p1.next;
            }
            n += 1;
        } while (p1 != p2);
        p2 = null;
        while (p2 != p1) {
            if (p2 == null) {
                p2 = pHead;
            } else {
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return p1;
    }
}
