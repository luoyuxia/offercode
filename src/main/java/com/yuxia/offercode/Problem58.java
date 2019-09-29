package com.yuxia.offercode;

public class Problem58 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node = new Problem58().deleteDuplication2(node1);
        System.out.println(node);
    }

    public ListNode deleteDuplication2(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(-1);
        ListNode trail = head;
        while (pHead != null) {
            ListNode node = pHead.next;
            boolean isDuplication = false;
            while (node != null && node.val == pHead.val) {
                isDuplication  = true;
                node = node.next;
            }
            if (!isDuplication) {
                trail.next = pHead;
                trail = trail.next;
            }
            pHead = node;
        }
        trail.next = null;
        return head.next;
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode p = pHead;
        ListNode pre = null;
        boolean isDuplication;
        while (p != null) {
            isDuplication = false;
            for (; p.next != null; p = p.next) {
                if (p.next.val == p.val) {
                    isDuplication = true;
                } else {
                    break;
                }
            }
            if (!isDuplication) {
                if (pre == null) {
                    pHead = p;
                    pre = pHead;
                } else {
                    pre.next = p;
                    pre = p;
                }
                p = p.next;
            } else {
                if (p.next != null && p.next.next != null && p.next.next.val != p.next.val) {
                    if (pre == null) {
                        pHead = p.next;
                        pre = pHead;
                    } else {
                        pre.next = p.next;
                        pre = p.next;
                    }
                    p = p.next.next;
                } else {
                    p = p.next;
                }
            }
        }
        if (pre != null) {
            pre.next = null;
        } else {
            pHead = null;
        }
        return pHead;
    }

}
