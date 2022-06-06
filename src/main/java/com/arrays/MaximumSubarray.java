package com.arrays;

//53. Maximum Subarray
//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int num : nums) {
            sum +=num;
            if(sum > max) max = sum;
            if(sum < 0) sum = 0;
        }
        return max;
    }
}
