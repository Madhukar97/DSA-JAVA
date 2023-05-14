package com.codestudio.dynamicprogramming;

//https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998?leftPanelTab=0
public class MaximumPathSumInTheMatrix {

    public static void main(String[] args) {

    }

    public static int getMaxPathSum(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            int sum = rec(matrix.length-1, i, matrix);
            if(ans < sum) ans = sum;
        }
        return ans;
    }

    //Normal recursion solution with TC = O(3^(i*j)) + O(j) and SC = O(i-1+j-1)
    public static int rec(int i, int j, int[][] matrix){
        if(i==0 && j>=0 && j<matrix[0].length) return matrix[i][j];
        if(i<0 || j<0 || j>=matrix[0].length) return Integer.MIN_VALUE;

        int up = rec(i-1, j, matrix);
        int ld = rec(i-1, j-1, matrix);
        int rd = rec(i-1, j+1, matrix);

        int maxSum = matrix[i][j] + Math.max(up, Math.max(ld,rd));
        return maxSum;

    }


    //Recursion with Memoization(Top-Down approach) solution TC = O(i*j) + O(j), SC = O(n-1+m-1) + dp[n][m]
    public static int getMaxPathSumDP(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            int sum = recDP(matrix.length-1, i, matrix, dp);
            if(ans < sum) ans = sum;
        }
        return ans;
    }

    public static int recDP(int i, int j, int[][] matrix, int[][] dp){
        if(i==0 && j>=0 && j<matrix[0].length) return matrix[i][j];
        if(i<0 || j<0 || j>=matrix[0].length) return Integer.MIN_VALUE;
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int up = recDP(i-1, j, matrix, dp);
        int ld = recDP(i-1, j-1, matrix, dp);
        int rd = recDP(i-1, j+1, matrix, dp);

        int maxSum = matrix[i][j] + Math.max(up, Math.max(ld,rd));
        dp[i][j] = maxSum;
        return maxSum;
    }

    //Tabulation(Bottom-Up approach) solution TC = O(i*j) + O(j), SC = dp[i][j]
    public static int getMaxPathSumTabulation(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int c=0;c<matrix[0].length;c++){
            dp[0][c] = matrix[0][c];
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int down = dp[i-1][j];

                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;

                if(j > 0) ld = dp[i-1][j-1];
                if(j < matrix[0].length-1) rd = dp[i-1][j+1];

                int maxSum = matrix[i][j] + Math.max(down, Math.max(ld, rd));
                dp[i][j] = maxSum;
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            int sum = dp[matrix.length-1][i];
            if(ans < sum) ans = sum;
        }
        return ans;
    }


    //Tabulation(Bottom-Up approach) with space optimization solution TC = O(i*j) + O(j), SC = dp[j]
    public static int getMaxPathSumTabulationWithSpaceOptimized(int[][] matrix) {
        int ans = Integer.MIN_VALUE;
        int[] precRow = new int[matrix[0].length];
        int[] currRow = new int[matrix[0].length];


        for(int c=0;c<matrix[0].length;c++){
            precRow[c] = matrix[0][c];
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int down = precRow[j];

                int ld = Integer.MIN_VALUE;
                int rd = Integer.MIN_VALUE;

                if(j > 0) ld = precRow[j-1];
                if(j < matrix[0].length-1) rd = precRow[j+1];

                int maxSum = matrix[i][j] + Math.max(down, Math.max(ld, rd));
                currRow[j] = maxSum;
            }
            precRow = currRow;
            currRow = new int[matrix[0].length];
        }

        for(int i=0;i<matrix[0].length;i++){
            int sum = precRow[i];
            if(ans < sum) ans = sum;
        }
        return ans;
    }

}
