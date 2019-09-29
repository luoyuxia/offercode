package com.yuxia.offercode;

public class Problem26 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null)
            return null;
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = pHead;
        while (cur != null) {
            RandomListNode random = cur.random;
            cur.next.random = random == null ? null : random.next;
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode head = pHead.next;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = next == null ? null : next.next;
            cur = next;
        }
        return head;
    }
}
