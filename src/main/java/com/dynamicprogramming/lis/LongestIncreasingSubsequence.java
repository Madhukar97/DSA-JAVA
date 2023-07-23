package com.dynamicprogramming.lis;

import java.util.Arrays;

//300. Longest Increasing Subsequence
//https://leetcode.com/problems/longest-increasing-subsequence/
//Striver DP series vid 41
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        System.out.println(Math.abs(-12));
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println("Index to replace:: " + binarySearch(nums,0,1,3));
        lengthOfLISDPWithBinarySearch(nums);
    }

    public int lengthOfLIS(int[] nums) {
        return rec(0,Integer.MIN_VALUE,nums);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public int rec(int i, int prev, int[] nums){
        if(i == nums.length) return 0;

        if(nums[i] > prev){
            return Math.max(1+rec(i+1,nums[i],nums), 0+rec(i+1,prev,nums));
        }
        return rec(i+1,prev,nums);
    }

    public int lengthOfLISMem(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length+1;j++){
                dp[i][j]=-1;
            }
        }
        return recMem(0,-1,nums,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2) , SC = O(n) + dp[n][n+1]
    public int recMem(int i, int prev, int[] nums, int[][] dp){
        if(i == nums.length) return 0;

        if(dp[i][prev+1] !=-1) return dp[i][prev+1];

        if(prev == -1 || nums[i] > nums[prev]){
            dp[i][prev+1] = Math.max(1+recMem(i+1,i,nums,dp), 0+recMem(i+1,prev,nums,dp));
            return dp[i][prev+1];
        }
        dp[i][prev+1] = recMem(i+1,prev,nums,dp);
        return dp[i][prev+1];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*n) , SC = dp[n+1][n+1]
    public int lengthOfLISTabulation(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev == -1 || nums[i] > nums[prev]){
                    dp[i][prev+1] = Math.max(1+dp[i+1][i+1], 0+dp[i+1][prev+1]);
                }
                else dp[i][prev+1] = dp[i+1][prev+1];
            }
        }

        return dp[0][0];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*n) , SC = 2*dp[n+1]
    public int lengthOfLISTabulationWithSpaceOptimization(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];

        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev == -1 || nums[i] > nums[prev]){
                    curr[prev+1] = Math.max(1+next[i+1], 0+next[prev+1]);
                }
                else curr[prev+1] = next[prev+1];
            }
            next=curr;
            curr=new int[n+1];
        }
        return next[0];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*n) , SC = 1*dp[n+1]
    public int lengthOfLISTabWithSingleArraySpaceOptimization(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];

        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev == -1 || nums[i] > nums[prev]){
                    next[prev+1] = Math.max(1+next[i+1], 0+next[prev+1]);
                }
                else next[prev+1] = next[prev+1];
            }
        }
        return next[0];
    }

    public static int lengthOfLISDPWithBinarySearch(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int prev=0;
        int len=1;

        for(int i=1;i<n;i++){
            if(nums[i] > dp[prev]){
                dp[prev+1] = nums[i];
                prev=prev+1;
                len++;
            }else{
                int lowerBound = binarySearch(dp,0,len-1,nums[i]);
                dp[lowerBound] = nums[i];

            }
            // System.out.println(Arrays.toString(dp));
        }
        return len;
    }
    //Special solution DP(Bottom-up approach) with Binary Search solution TC = O(n*Log(n)) , SC = dp[n]
    public static int binarySearch(int[] nums, int start, int end, int val){
        int mid = 0;
        int l=start;
        int r=end;

        while(l<=r){
            mid = l+(r-l)/2;
            if(nums[mid] == val) return mid;
            if(nums[mid] < val) {
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }
}
