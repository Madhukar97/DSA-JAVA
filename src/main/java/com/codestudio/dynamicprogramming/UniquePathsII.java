package com.codestudio.dynamicprogramming;

import java.util.ArrayList;

//https://www.codingninjas.com/codestudio/problems/maze-obstacles_977241?leftPanelTab=0
public class UniquePathsII {
    public static void main(String[] args) {

    }

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[mat.size()][mat.get(0).size()];
        for(int i=0;i<mat.size();i++){
            for(int j=0;j<mat.get(0).size();j++){
                dp[i][j] = -1;
            }
        }
        return rec(n-1,m-1,mat,dp)%(int)(Math.pow(10, 9)+7);
    }

    //Recursion with Memoization solution TC = O(n*m), SC = O(n-1+m-1) + dp[n][m]
    public static int rec(int n, int m, ArrayList<ArrayList<Integer>> mat, int[][] dp){
        if(n==0 & m==0) return 1;
        if(n<0 || m<0) return 0;

        if(mat.get(n).get(m) == -1){
            return 0;
        }

        if(dp[n][m] != -1) return dp[n][m];

        int up = rec(n-1,m,mat,dp);
        int left = rec(n,m-1,mat,dp);

        dp[n][m] = (up+left)%(int)(Math.pow(10, 9)+7);
        return (up+left)%(int)(Math.pow(10, 9)+7);
    }

    //Tabulation solution TC = O(n*m), SC = dp[n][m] or O(n*m)
    static int mazeObstaclesTabulation(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[mat.size()][mat.get(0).size()];

        for(int i=0;i<mat.size();i++){
            for(int j=0;j<mat.get(0).size();j++){
                if(i==0 && j==0) dp[i][j] = 1;
                else{
                    int up=0;
                    int left=0;

                    if(mat.get(i).get(j) != -1) {
                        if(i>0) up = dp[i-1][j];
                        if(j>0) left = dp[i][j-1];
                    }

                    dp[i][j] = (up+left)%(int)(Math.pow(10, 9)+7);
                }
            }
        }
        return dp[n-1][m-1]%(int)(Math.pow(10, 9)+7);
    }

    //Tabulation with SpaceOptimization solution TC = O(n*m), SC = dp[m] or O(m)
    static int mazeObstaclesSpaceOptimization(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[] prevRow = new int[mat.get(0).size()];
        int[] currRow = new int[mat.get(0).size()];
        int temp=1;

        for(int i=0;i<mat.size();i++){
            for(int j=0;j<mat.get(0).size();j++){
                int up=0;
                int left=0;

                if(mat.get(i).get(j) != -1) {
                    up = prevRow[j];
                    left = temp;
                }
                temp =  (up+left)%(int)(Math.pow(10, 9)+7);
                currRow[j] = (up+left)%(int)(Math.pow(10, 9)+7);

            }
            temp = 0;
            prevRow = currRow;
            currRow = new int[mat.get(0).size()];
        }
        return prevRow[m-1]%(int)(Math.pow(10, 9)+7);
    }

}
