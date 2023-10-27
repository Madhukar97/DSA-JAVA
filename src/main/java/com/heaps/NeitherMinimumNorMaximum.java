package com.heaps;

import java.util.PriorityQueue;

//2733. Neither Minimum nor Maximum
//https://leetcode.com/problems/neither-minimum-nor-maximum/description/
public class NeitherMinimumNorMaximum {
    public int findNonMinOrMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int n : nums){
            minHeap.add(n);
        }
        if(minHeap.size()<=2) return -1;
        minHeap.poll();
        return minHeap.peek();
    }

    //Most Optimal sol ??
    public int findNonMinOrMaxSol2(int[] nums) {
        if(nums.length < 3) return -1;
        return Math.max(Math.min(Math.max(nums[0], nums[1]), nums[2]), Math.min(nums[0], nums[1]));
    }
}
