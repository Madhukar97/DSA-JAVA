package com.arrays;

//1749. Maximum Absolute Sum of Any Subarray
//https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/description/
public class MaximumAbsoluteSumOfAnySubarray {
    //Optimal sol Using Kadan's Algorithm
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int preSum=0;
            int max = Integer.MIN_VALUE;
            for(int i : nums){
                preSum+=i;
                max = Math.max(max, preSum);
                if(preSum < 0) preSum=0;
            }
            preSum=0;
            int min = Integer.MAX_VALUE;
            for(int i : nums){
                preSum+=i;
                min = Math.min(min, preSum);
                if(preSum > 0) preSum=0;
            }
            return Math.max(max, Math.abs(min));
        }
    }
}
