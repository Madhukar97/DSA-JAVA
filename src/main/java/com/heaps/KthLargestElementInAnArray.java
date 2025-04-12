package com.heaps;

import java.util.*;

//215. Kth Largest Element in an Array
//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElementInAnArray {
    //Brute force sol using sorting
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //Optimal sol using Heaps
    public int findKthLargestSol2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int n : nums){
            minHeap.add(n);
            if(minHeap.size() > k) minHeap.poll();
        }
        return minHeap.peek();
    }


     //Revision 5
     class Solution2 {
         public int findKthLargest(int[] nums, int k) {
             PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1,e2) -> e2-e1);
             for(int i : nums) maxHeap.add(i);
             while(!maxHeap.isEmpty()){
                 int ans = maxHeap.poll();
                 k--;
                 if(k==0) return ans;
             }
             return -1;
         }
     }
}
