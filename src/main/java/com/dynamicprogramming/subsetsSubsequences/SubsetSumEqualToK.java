package com.dynamicprogramming.subsetsSubsequences;

//https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954
public class SubsetSumEqualToK {
    public static void main(String[] args) {
        System.out.println();
    }


    public static boolean subsetSumToK(int n, int k, int arr[]){
        return rec(n-1, k, arr);
    }

    ////Normal recursion solution with TC = O(2^n) and SC = O(n)
    public static boolean rec(int index, int target, int[] arr){
        if(arr[index] == target) return true;
        if(index == 0) return arr[0] == target;

        boolean notTake = rec(index-1, target, arr);
        boolean take = false;
        if(arr[index] <= target) take = rec(index-1, target-arr[index], arr);

        return take || notTake;
    }

    public static boolean subsetSumToKDP(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n;i++){
            for(int j=0;j<k+1;j++){
                dp[i][j] = -1;
            }
        }
        return recMemoization(n-1, k, arr, dp);
    }

    //Recursion with Memoization(Top-Down approach) solution TC = O(n*k) , SC = O(n) + dp[n][k+1]
    public static boolean recMemoization(int index, int target, int[] arr, int[][] dp){
        if(arr[index] == target) return true;
        if(index == 0) return arr[0] == target;
        if(dp[index][target] != -1) {
            if(dp[index][target] == 1) return true;
            else return false;
        }

        boolean notTake = recMemoization(index-1, target, arr, dp);
        boolean take = false;
        if(arr[index] <= target) take = recMemoization(index-1, target-arr[index], arr, dp);

        int val=0;
        if(take || notTake) val = 1;
        dp[index][target] = val;
        return take || notTake;
    }


    //Tabulation(Bottom-up approach) solution TC = O(n*k) , SC = dp[n][k+1]
    public static boolean subsetSumToKTabulation(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n+1][k+1];
        if(arr[0]<=k)dp[0][arr[0]] = true;

        for(int i=0; i<n;i++){
            dp[i][0] = true;
        }

        for(int index=1; index<n; index++){
            for(int target=k;target>=0;target--){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(arr[index] <= target) take = dp[index-1][target-arr[index]];
                dp[index][target] = take || notTake;
            }
        }

        return dp[n-1][k];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*k) , SC = dp[k+1]
    public static boolean subsetSumToKSpaceOptimization(int n, int k, int arr[]){
        boolean[] prev = new boolean[k+1];
        boolean[] curr = new boolean[k+1];

        if(arr[0]<=k)prev[arr[0]] = true;
        prev[0] = true;

        for(int index=1; index<n; index++){
            for(int target=k;target>=0;target--){
                boolean notTake = prev[target];
                boolean take = false;
                if(arr[index] <= target) take = prev[target-arr[index]];
                curr[target] = take || notTake;
            }
            prev = curr;
            curr = new boolean[k+1];
        }
        return prev[k];
    }

    // Revision 5
    // Memoization
    public class Solution {
        public static boolean subsetSumToK(int n, int k, int arr[]){
            int total=0;
            for(int i : arr) total+=i;
            Boolean[][] sums = new Boolean[n][total+1];
            return checkSubsetSum(n-1, k, arr, 0, sums);
        }

        private static boolean checkSubsetSum(int index, int k, int[] arr, int sum, Boolean[][] sums){
            if(sum == k) return true;
            if(index < 0) return false;
            if(sums[index][sum] != null) return sums[index][sum];

            // pick
            boolean pick = checkSubsetSum(index-1, k, arr, sum+arr[index], sums);
            // not pick
            boolean notPick = checkSubsetSum(index-1, k, arr, sum, sums);
            return sums[index][sum] = pick || notPick;
        }
    }
}
