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

    // Tabulation
    class Solution {
        public int rob(int[] nums) {
            int n=nums.length;
            if(n==1) return nums[0];
            int[] dp = new int[n];
            int[] dp2 = new int[n];

            for(int i=0;i<n-1;i++){
                int pick = nums[i];
                if(i-2>=0) pick += dp[i-2];
                int notPick = 0;
                if(i-1>=0) notPick = dp[i-1];
                dp[i] = Math.max(pick, notPick);
            }

            for(int i=1;i<n;i++){
                int pick = nums[i];
                if(i-2>=1) pick += dp2[i-2];
                int notPick = 0;
                if(i-1>=1) notPick = dp2[i-1];
                dp2[i] = Math.max(pick, notPick);
            }
            return Math.max(dp[n-2], dp2[n-1]);
        }
    }

    //Space Optimization
    class Solution2 {
        public int rob(int[] nums) {
            int n=nums.length;
            if(n==1) return nums[0];
            int prev2 = 0;
            int prev1 = 0;
            int curr1 = 0;
            int curr2 = 0;

            for(int i=0;i<n-1;i++){
                int pick = nums[i];
                if(i-2>=0) pick += prev2;

                int notPick = 0;
                if(i-1>=0) notPick = prev1;
                curr1 = Math.max(pick, notPick);
                prev2=prev1;
                prev1=curr1;
            }

            prev2 = 0;
            prev1 = 0;

            for(int i=1;i<n;i++){
                int pick = nums[i];
                if(i-2>=1) pick += prev2;

                int notPick = 0;
                if(i-1>=1) notPick = prev1;
                curr2 = Math.max(pick, notPick);
                prev2=prev1;
                prev1=curr2;
            }
            return Math.max(curr1, curr2);
        }
    }
}
