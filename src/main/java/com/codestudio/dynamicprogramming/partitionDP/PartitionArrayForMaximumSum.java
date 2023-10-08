package com.codestudio.dynamicprogramming.partitionDP;

//Partition Array for Maximum Sum
//https://www.codingninjas.com/studio/problems/maximum-subarray_3755255
//Striver DP series vid 54
public class PartitionArrayForMaximumSum {
    //Normal recursion solution with TC = O(k^n)*n and SC = O(n)
    //getting TLE error
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return rec(0,arr,k);
    }

    public int rec(int i, int[] arr, int k){
        if(i == arr.length) return 0;

        int len=0;
        int maxi = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len*maxi + rec(j+1, arr, k);
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
    //recursion with memoization solution with TC = O(n*k) and SC = O(n) + dp[n]
    public int maxSumAfterPartitioningMem(int[] arr, int k) {
        int[] dp = new int[arr.length];
        for(int i=0;i<arr.length;i++) dp[i] = -1;

        return recMem(0,arr,k,dp);
    }

    public int recMem(int i, int[] arr, int k, int[] dp){
        if(i == arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        int len=0;
        int maxi = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = len*maxi + recMem(j+1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }
        dp[i] = maxSum;
        return maxSum;
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*k) , SC = dp[n+1]
    public int maxSumAfterPartitioningTabulation(int[] arr, int k) {
        int[] dp = new int[arr.length+1];

        for(int i=arr.length-1;i>=0;i--){
            int len=0;
            int maxi = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for(int j=i;j<Math.min(arr.length,i+k);j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len*maxi + dp[j+1];
                maxSum = Math.max(maxSum, sum);
            }
            dp[i] = maxSum;
        }

        return dp[0];
    }
}
