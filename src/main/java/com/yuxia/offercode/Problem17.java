package com.yuxia.offercode;

public class Problem17 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    private ListNode append(ListNode tail, ListNode node) {
        node.next = null;
        tail.next = node;
        return tail.next;
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        ListNode next;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                next = list1.next;
                tail = append(tail, list1);
                list1 = next;
            } else {
                next = list2.next;
                tail = append(tail, list2);
                list2 = next;
            }
        }
        while (list1 != null) {
            next = list1.next;
            tail = append(tail, list1);
            list1 = next;
        }
        while (list2 != null) {
            next = list2.next;
            tail = append(tail, list2);
            list2 = next;
        }
        return head.next;
    }
}
