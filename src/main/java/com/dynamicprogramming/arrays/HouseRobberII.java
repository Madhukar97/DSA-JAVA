package com.dynamicprogramming.arrays;

import java.util.Arrays;

//213. House Robber II
//https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobberII {
    //Optimal sol using recursion and 1D DP
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        int case1 = rec(nums,0,dp,nums.length-1);
        Arrays.fill(dp,-1);
        int case2 = rec(nums,1,dp,nums.length);
        return Math.max(case1,case2);
    }

    public int rec(int[] nums, int i, int[] dp, int end){
        if(i >= end) return 0;

        if(dp[i] != -1 ) return dp[i];
        int rob = nums[i]+rec(nums,i+2,dp,end);
        int dontRob = rec(nums,i+1,dp,end);

        dp[i] = Math.max(rob,dontRob);
        return dp[i];
    }
}
