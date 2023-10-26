package com.dynamicprogramming.arrays;

import java.util.Arrays;

//198. House Robber
//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    //Brute Force

    //Optimal using 2D dp
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int sum=0;
        for(int n : nums) sum+=n;
        int[][] dp = new int[nums.length][sum+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return rec(nums,0,0,dp);
    }

    public int rec(int[] nums, int index, int val, int[][] dp){
        if(index == nums.length || index == nums.length+1) return val;

        if(dp[index][val] != -1) return dp[index][val];
        int rob = rec(nums, index+2, val+nums[index], dp);
        int dontRob = rec(nums, index+1, val, dp);

        dp[index][val] = Math.max(rob, dontRob);
        return dp[index][val];
    }

    //Optimal 2 with 1D dp
    public int robSol2(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return rec2(nums,0,dp);
    }

    public int rec2(int[] nums, int index, int[] dp){
        if(index == nums.length || index == nums.length+1) return 0;

        if(dp[index] != -1) return dp[index];

        int rob = nums[index] + rec2(nums, index+2, dp);
        int dontRob = rec2(nums, index+1, dp);

        dp[index] = Math.max(rob, dontRob);
        return dp[index];
    }

    //Tabulation
    public int robsol3(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);

        int[] dp = new int[nums.length];
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-1],nums[n-2]);

        for(int index=n-3;index>=0;index--){
            int rob = nums[index] + dp[index+2];
            int dontRob = dp[index+1];

            dp[index] = Math.max(rob, dontRob);
        }
        return dp[0];
    }
}
