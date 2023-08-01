package com.codestudio.dynamicprogramming.partitionDP;

//Mining Diamonds
//https://www.codingninjas.com/studio/problems/mining-diamonds_4244494?leftPanelTab=0
//Striver DP series 51
public class MiningDiamonds {
    //Normal recursion solution with TC = O(2^n)*n and SC = O(n)
    //getting TLE error
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] =1 ;
        arr[n+1]=1;
        for(int i=0;i<n;i++) arr[i+1] = nums[i];

        return rec(1,n,arr);
    }

    public int rec(int i, int j, int[] nums){
        if(i > j) return 0;

        int max = Integer.MIN_VALUE;
        for(int b=i;b<=j;b++){
            int coins = nums[i-1]*nums[b]*nums[j+1] + rec(i,b-1,nums) + rec(b+1,j,nums);
            max=Math.max(max,coins);
        }
        return max;
    }

    public int maxCoinsMem(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] =1 ;
        arr[n+1]=1;
        for(int i=0;i<n;i++) arr[i+1] = nums[i];

        int[][] dp = new int[n+2][n+2];
        for(int i=0;i<n+2;i++){
            for(int j=0;j<n+2;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(1,n,arr,dp);
    }
    //recursion with memoization solution with TC = O(n*n)*n and SC = O(n) + dp[n+2][n+2]
    public int recMem(int i, int j, int[] nums, int[][] dp){
        if(i > j) return 0;

        if(dp[i][j]  != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int b=i;b<=j;b++){
            int coins = nums[i-1]*nums[b]*nums[j+1] + recMem(i,b-1,nums,dp) + recMem(b+1,j,nums,dp);
            max=Math.max(max,coins);
        }
        dp[i][j] = max;
        return max;
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*n)*n , SC = dp[n+2][n+2]
    public static int maxCoinsTabulation(int a[]) {
        int n=a.length;
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++) arr[i+1] = a[i];

        int[][] dp = new int[n+2][n+2];
        for(int i=n;i>0;i--){
            for(int j=i;j<n+1;j++){
                int max = Integer.MIN_VALUE;
                for(int d=i;d<=j;d++){
                    int coins = arr[i-1]*arr[d]*arr[j+1] + dp[i][d-1] + dp[d+1][j];
                    max=Math.max(max,coins);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];
    }

}
