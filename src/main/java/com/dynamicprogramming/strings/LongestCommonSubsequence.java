package com.dynamicprogramming.strings;

//1143. Longest Common Subsequence
//https://leetcode.com/problems/longest-common-subsequence/description/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return rec(text1.length()-1, text2.length()-1, text1, text2);
    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    public int rec(int i1, int i2, String s1, String s2){
        if(i1<0 || i2<0) return 0;

        if(s1.charAt(i1) == s2.charAt(i2)) return 1+rec(i1-1,i2-1,s1,s2);
        return Math.max(rec(i1-1,i2,s1,s2), rec(i1,i2-1,s1,s2));
    }

    public int longestCommonSubsequenceMem(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n][m];

        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(n-1, m-1, text1, text2, dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public int recMem(int i1, int i2, String s1, String s2, int[][] dp){
        if(i1<0 || i2<0) return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(s1.charAt(i1) == s2.charAt(i2)) {
            dp[i1][i2] = 1+recMem(i1-1,i2-1,s1,s2,dp);
            return dp[i1][i2];
        }
        dp[i1][i2] = Math.max(recMem(i1-1,i2,s1,s2,dp), recMem(i1,i2-1,s1,s2,dp));
        return dp[i1][i2];
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public int longestCommonSubsequenceTabWithSpaceOptimization(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(text1.charAt(i1-1) == text2.charAt(i2-1)) {
                    dp[i1][i2] = 1+dp[i1-1][i2-1];
                }
                else dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }
        return dp[n][m];
    }
}
