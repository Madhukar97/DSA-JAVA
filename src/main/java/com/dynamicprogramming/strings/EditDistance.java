package com.dynamicprogramming.strings;

import java.util.Arrays;

//72. Edit Distance
//https://leetcode.com/problems/edit-distance/description/
//Striver DP series vid 33 String matching not LCS
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        return rec(word1.length()-1,word2.length()-1,word1,word2);
    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    public static int rec(int i1, int i2, String s1, String s2){
        //base case
        if(i1<0) return i2+1;
        if(i2<0) return i1+1;


        //string matching all possibilities
        if(s1.charAt(i1) == s2.charAt(i2)) return 0 + rec(i1-1,i2-1,s1,s2);
        int delete = 1+rec(i1-1,i2,s1,s2);
        int replace = 1+rec(i1-1,i2-1,s1,s2);
        int insert = 1+rec(i1,i2-1,s1,s2);

        return Math.min(delete, Math.min(replace,insert));
    }
    public int minDistanceMem(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(word1.length()-1,word2.length()-1,word1,word2,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public static int recMem(int i1, int i2, String s1, String s2, int[][] dp){
        //base case
        if(i1<0) return i2+1;
        if(i2<0) return i1+1;

        if(dp[i1][i2] != -1) return dp[i1][i2];

        //string matching all possibilities
        if(s1.charAt(i1) == s2.charAt(i2)) {
            dp[i1][i2] =  0 + recMem(i1-1,i2-1,s1,s2,dp);
            return dp[i1][i2];
        }
        int delete = 1+recMem(i1-1,i2,s1,s2,dp);
        int replace = 1+recMem(i1-1,i2-1,s1,s2,dp);
        int insert = 1+recMem(i1,i2-1,s1,s2,dp);

        dp[i1][i2] = Math.min(delete, Math.min(replace,insert));
        return dp[i1][i2];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public int minDistanceTabulation(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int j=0;j<m+1;j++) dp[0][j] = j;
        for(int i=0;i<n+1;i++) dp[i][0] = i;

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(word1.charAt(i1-1) == word2.charAt(i2-1)) {
                    dp[i1][i2] =  0 + dp[i1-1][i2-1];
                }else{
                    int delete = 1+dp[i1-1][i2];
                    int replace = 1+dp[i1-1][i2-1];
                    int insert = 1+dp[i1][i2-1];

                    dp[i1][i2] = Math.min(delete, Math.min(replace,insert));
                }
            }
        }
        return dp[n][m];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*m) , SC = 2*dp[m+1]
    public static int minDistanceTabulationWithSpaceOptimization(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int j = 0; j < m + 1; j++) prev[j] = j;

        for (int i1 = 1; i1 < n + 1; i1++) {
            curr[0] = i1;   // for every row zeroth column should have i as base case
            for (int i2 = 1; i2 < m + 1; i2++) {
                if (word1.charAt(i1 - 1) == word2.charAt(i2 - 1)) {
                    curr[i2] = 0 + prev[i2 - 1];
                } else {
                    int delete = 1 + prev[i2];
                    int replace = 1 + prev[i2 - 1];
                    int insert = 1 + curr[i2 - 1];

                    curr[i2] = Math.min(delete, Math.min(replace, insert));
                }
            }
            prev = curr;
            curr = new int[m + 1];
        }
        return prev[m];
    }

    //Revision 2
    //Memoization from left to right (0 to n)
    class Solution {
        public int minDistance(String word1, String word2) {
            int n1 = word1.length();
            int n2 = word2.length();
            int[][] dp = new int[n1][n2];
            for(int[] row : dp) Arrays.fill(row, -1);
            return rec(word1, word2, 0 ,0, dp);
        }

        public int rec(String s1, String s2, int i1, int i2, int[][] dp){
            if(i1 == s1.length() && i2 == s2.length()) return 0;
            else if(i1 == s1.length()) return s2.length()-i2;
            else if(i2 == s2.length()) return s1.length()-i1;

            if(dp[i1][i2] != -1 ) return dp[i1][i2];

            if(s1.charAt(i1) == s2.charAt(i2)){
                dp[i1][i2] = rec(s1,s2,i1+1,i2+1, dp);
                return dp[i1][i2];
            }
            int insert = rec(s1,s2,i1,i2+1, dp);
            int delete = rec(s1,s2,i1+1,i2, dp);
            int replace = rec(s1,s2,i1+1,i2+1, dp);
            dp[i1][i2] = 1+Math.min(insert, Math.min(delete, replace));
            return dp[i1][i2];
        }
    }

    //Revision 2
    //Tabulation from right to left (n to 0)
    public int minDistanceTab2(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int j=0;j<=n2;j++) dp[n1][j] = n2-j;
        for(int i=0;i<=n1;i++) dp[i][n2] = n1-i;

        for(int i1=n1-1;i1>=0;i1--){
            for(int i2=n2-1;i2>=0;i2--){
                if(word1.charAt(i1) == word2.charAt(i2)){
                    dp[i1][i2] = dp[i1+1][i2+1];
                }
                else{
                    int insert = dp[i1][i2+1];
                    int delete = dp[i1+1][i2];
                    int replace = dp[i1+1][i2+1];
                    dp[i1][i2] = 1+Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[0][0];

        // return rec(word1, word2, 0 ,0, dp);
    }
}
