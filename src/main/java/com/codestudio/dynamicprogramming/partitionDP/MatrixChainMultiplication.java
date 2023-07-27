package com.codestudio.dynamicprogramming.partitionDP;

//Matrix Chain Multiplication
//https://www.codingninjas.com/studio/problems/matrix-chain-multiplication_975344
public class MatrixChainMultiplication {
    public static int matrixMultiplication(int[] arr , int N) {
        return rec(1, N-1, arr);
    }
    //Normal recursion solution with TC = O(2^n)*n and SC = O(n)
    //getting TLE error
    public static int rec(int i, int j, int[] arr){
        if(i==j) return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j] + rec(i,k,arr) + rec(k+1,j,arr);
            min = Math.min(min, steps);
        }
        return min;
    }

    public static int matrixMultiplicationMem(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j]=-1;
            }
        }

        return recMem(1, N-1, arr,dp);
    }
    //recursion with memoization solution with TC = O(n*n)*n and SC = O(n) + dp[n][n]
    public static int recMem(int i, int j, int[] arr, int[][] dp){
        if(i==j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps = arr[i-1]*arr[k]*arr[j] + recMem(i,k,arr,dp) + recMem(k+1,j,arr,dp);
            min = Math.min(min, steps);
        }
        dp[i][j] = min;
        return dp[i][j];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*n)*n , SC = dp[n][n]
    public static int matrixMultiplicationTabulation(int[] arr , int N) {
        int[][] dp = new int[N][N];

        for(int i=N-1;i>0;i--){
            for(int j=i+1;j<N;j++){
                int min = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][N-1];
    }


}
