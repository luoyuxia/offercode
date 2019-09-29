package com.yuxia.offercode;

import java.util.PriorityQueue;

public class Problem65 {
    public static void main(String[] args) {
        Problem65 problem65 = new Problem65();
        problem65.Insert(65);
        problem65.Insert(60);
        problem65.Insert(63);
        problem65.Insert(62);
        problem65.Insert(60);
    }
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
    private int count = 0;
    public void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int n = maxHeap.poll();
            minHeap.offer(n);
        } else {
            minHeap.offer(num);
            int n = minHeap.poll();
            maxHeap.offer(n);
        }
        count += 1;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek().doubleValue();
        }
    }
}
