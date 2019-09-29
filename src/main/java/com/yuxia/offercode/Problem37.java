package com.yuxia.offercode;
public class Problem37 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;int len2 = 0;ListNode node = pHead1;
        while (node != null) {
            node = node.next;
            len1 += 1;
        }
        node = pHead2;
        while (node != null) {
            node = node.next;
            len2 += 1;
        }
        ListNode longList = pHead1;
        ListNode shortList = pHead2;
        if (len1 < len2) {
            longList = pHead2;
            shortList = pHead1;
        }
        int diff = Math.abs(len1 - len2);
        for (int i = 0; i < diff; i++) longList = longList.next;
        while (longList != null) {
            if (longList == shortList) return longList;
            longList = longList.next; shortList = shortList.next;
        }
        return null;
    }
}
