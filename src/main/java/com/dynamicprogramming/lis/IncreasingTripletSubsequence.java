package com.dynamicprogramming.lis;

import java.util.ArrayList;

//334. Increasing Triplet Subsequence
//https://leetcode.com/problems/increasing-triplet-subsequence/description/
//Striver DP series vid 44
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

    }
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        return rec(n-1,n,0,nums);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public boolean rec(int i, int rightIndex, int count, int[] nums){
        if(i < 0){
            return count >= 3;
        }

        if(rightIndex == nums.length || nums[i] < nums[rightIndex]){
            // System.out.println("Index :: " + i + ", COUNT::"+ count);
            boolean take =  rec(i-1, i, count+1, nums);
            boolean notTake = rec(i-1, rightIndex, count, nums);
            return take || notTake;
        }
        return rec(i-1, rightIndex, count, nums);
    }

    public boolean increasingTripletMem(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(n-1,n,0,nums,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2) , SC = O(n) + dp[n][n+1]
    public boolean recMem(int i, int rightIndex, int count, int[] nums, int[][] dp){
        if(i < 0){
            return count >= 3;
        }

        if(dp[i][rightIndex] != -1) return dp[i][rightIndex]==1 ? true : false;

        if(rightIndex == nums.length || nums[i] < nums[rightIndex]){
            // System.out.println("Index :: " + i + ", COUNT::"+ count);
            boolean take =  recMem(i-1, i, count+1, nums,dp);
            boolean notTake = recMem(i-1, rightIndex, count, nums,dp);
            dp[i][rightIndex] = (take || notTake) ? 1 : 0;
            return take || notTake;
        }
        dp[i][rightIndex] = recMem(i-1, rightIndex, count, nums,dp) ? 1 : 0;
        return dp[i][rightIndex]==1 ? true : false;
    }
    //Using LIS algorithm return len>=3
    //Tabulation(Bottom-up approach) solution TC = O(n*n) , SC = dp[n+1][n+1]
    public boolean increasingTripletTabulation(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];

        for(int i=nums.length-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev == -1 || nums[i] > nums[prev]){
                    dp[i][prev+1] = Math.max(1+dp[i+1][i+1], 0+dp[i+1][prev+1]);
                }else{
                    dp[i][prev+1] = dp[i+1][prev+1];
                }
            }
        }
        return dp[0][0]>=3;
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*n) , SC = 2*dp[n+1]
    public static int ninjaGameTabWith2ArraySpaceOptimization(ArrayList<Integer> nums, int n) {
        int[] next = new int[n+1];
        int[] curr = new int[n+1];

        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev == -1 || nums.get(i) > nums.get(prev)){
                    curr[prev+1] = Math.max(1+next[i+1], 0+next[prev+1]);
                }else{
                    curr[prev+1] = next[prev+1];
                }
            }
            next=curr;
            curr = new int[n+1];
        }
        return next[0]>=3 ? 1 : 0;
    }

    //Tabulation(Bottom-up approach) with 1 Array space optimization solution TC = O(n*n) , SC = 1*dp[n+1]
    public static int ninjaGameTabWith1ArraySpaceOptimization(ArrayList<Integer> nums, int n) {
        int[] next = new int[n+1];

        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                if(prev == -1 || nums.get(i) > nums.get(prev)){
                    next[prev+1] = Math.max(1+next[i+1], 0+next[prev+1]);
                }else{
                    next[prev+1] = next[prev+1];
                }
            }
        }
        return next[0]>=3 ? 1 : 0;
    }

    //Special solution DP(Bottom-up approach) with Binary Search solution TC = O(n*Log(n)) , SC = dp[n]
    public boolean increasingTripletDPWithBinarySearch(int[] nums) {
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
        return len>=3;
    }

    public int binarySearch(int[] nums, int start, int end, int val){
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
