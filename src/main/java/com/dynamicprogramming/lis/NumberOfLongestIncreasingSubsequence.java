package com.dynamicprogramming.lis;

//673. Number of Longest Increasing Subsequence
//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
public class NumberOfLongestIncreasingSubsequence {
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*n) , SC = 1*dp[n+1]
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        for(int i=0;i<n;i++) {
            dp[i]=1;
            count[i]=1;
        }

        int maxi=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(1+dp[j] > dp[i]){
                        count[i]=count[j];
                    }else if(1+dp[j] == dp[i]) {
                        count[i]+=count[j];
                    }
                    dp[i]=Math.max(dp[i], 1+dp[j]);
                    maxi=Math.max(maxi, dp[i]);
                }
            }
        }
        // System.out.println("Maxi :: " + maxi);
        // System.out.println("DP1 :: " + Arrays.toString(dp));
        // System.out.println("Count :: " + Arrays.toString(count));
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxi) ans+=count[i];
        }
        return ans;
    }
}
