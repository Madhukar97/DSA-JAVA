package com.backtracking;

import java.util.Arrays;

//377. Combination Sum IV
//https://leetcode.com/problems/combination-sum-iv/description/
public class CombinationSumIV {
    //Brute force sol using recursion
    public int combinationSum4(int[] nums, int target) {
        return rec(nums, 0, target);
    }

    public int rec(int[] nums, int index, int target){
        if(target == 0) return 1;
        if(index == nums.length || target < 0) return 0;

        //pick
        int pick = rec(nums, 0, target-nums[index]);
        //not pick
        int notPick = rec(nums, index+1, target);
        return pick+notPick;
    }

    //Optimal sol using DP and Memoization
    public int combinationSum4Mem(int[] nums, int target) {
        int[][] dp = new int[nums.length][target+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return rec(nums, 0, target, dp);
    }

    public int rec(int[] nums, int index, int target, int[][] dp){
        if(target == 0) return 1;
        if(index == nums.length || target < 0) return 0;

        if(dp[index][target] != -1) return dp[index][target];

        //pick
        int pick = rec(nums, 0, target-nums[index], dp);
        //not pick
        int notPick = rec(nums, index+1, target, dp);
        dp[index][target] = pick+notPick;
        return dp[index][target];
    }
}
