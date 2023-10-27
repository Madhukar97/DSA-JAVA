package com.heaps;

import java.util.PriorityQueue;

//414. Third Maximum Number
//https://leetcode.com/problems/third-maximum-number/description/
public class ThirdMaximumNumber {
    //using heaps
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int n : nums){
            if(!minHeap.contains(n)) minHeap.add(n);
            if(minHeap.size() > 3) minHeap.poll();
        }
        if(minHeap.size() < 3){
            while(minHeap.size()>1) minHeap.poll();
            return minHeap.peek();
        }
        return minHeap.peek();
    }
}
