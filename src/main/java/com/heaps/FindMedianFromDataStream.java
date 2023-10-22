package com.heaps;

import java.util.*;

//295. Find Median from Data Stream
//https://leetcode.com/problems/find-median-from-data-stream/description/
public class FindMedianFromDataStream {
    //1. Using ArrayList (TLE - 17/21 passed):
    class MedianFinder {
        List<Double> list;

        public MedianFinder() {
            this.list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(Double.parseDouble(""+num));
        }

        public double findMedian() {
            // System.out.println("List : " + list.toString());
            Collections.sort(list);
            if(list.size() == 0) return 0;
            else if(list.size() %2 == 1) return list.get(list.size()/2);
            else return (list.get(list.size()/2)+list.get(list.size()/2-1))/2;
        }
    }

    //sol 2 using heaps
    class MedianFinder2 {
        private PriorityQueue<Integer> minHeap;
        private PriorityQueue<Integer> maxHeap;

        public MedianFinder2() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= num) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            balance();
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else if (maxHeap.size() < minHeap.size()) {
                return minHeap.peek();
            }
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }

        private void balance() {
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }
}
