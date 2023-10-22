package com.heaps;

import java.util.*;

//703. Kth Largest Element in a Stream
//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementInAStream {
    //Sol using Heaps
    class KthLargest {

        PriorityQueue<Integer> minHeap;
        int k;

        public KthLargest(int k, int[] nums) {
            this.minHeap = new PriorityQueue<>();
            this.k=k;
            for(int i=0;i<nums.length;i++){
                minHeap.add(nums[i]);
                if(minHeap.size() > k) minHeap.poll();
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if(minHeap.size() > k) minHeap.poll();
            return minHeap.peek();
        }
    }

}
