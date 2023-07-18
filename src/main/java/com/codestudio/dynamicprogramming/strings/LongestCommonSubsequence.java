package com.codestudio.dynamicprogramming.strings;

//Longest Common Subsequence
//https://www.codingninjas.com/studio/problems/longest-common-subsequence_1063255
//Striver DP series vid 25
public class LongestCommonSubsequence {
    public static void main(String[] args) {

    }

    public static int getLengthOfLCS(String  str1, String  str2) {
        return rec(str1.length()-1, str2.length()-1, str1,str2);
    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    public static int rec(int i1, int i2, String s1, String s2){
        if(i1 < 0 || i2 < 0) return 0;

        if(s1.charAt(i1) == s2.charAt(i2)) return 1 + rec(i1-1,i2-1,s1,s2);
        return Math.max(rec(i1-1,i2,s1,s2), rec(i1,i2-1,s1,s2));
    }

    public static int getLengthOfLCSMem(String  str1, String  str2)
    {
        int n=str1.length();
        int m=str2.length();

        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        recMem(str1.length()-1, str2.length()-1, str1,str2, dp);
        return dp[n-1][m-1];
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public static int recMem(int i1, int i2, String s1, String s2, int[][] dp){
        if(i1 < 0 || i2 < 0) return 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(s1.charAt(i1) == s2.charAt(i2)){
            dp[i1][i2] = 1 + recMem(i1-1,i2-1,s1,s2,dp);
            return dp[i1][i2];
        }
        dp[i1][i2] = Math.max(recMem(i1-1,i2,s1,s2,dp), recMem(i1,i2-1,s1,s2,dp));
        return dp[i1][i2];
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public static int getLengthOfLCSTabulation(String  str1, String  str2)
    {
        int n=str1.length();
        int m=str2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i1=1;i1<=n;i1++){
            for(int i2=1;i2<=m;i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)) dp[i1][i2] = 1 + dp[i1-1][i2-1];
                else dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }
        return dp[n][m];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*m) , SC = 2*dp[m+1]
    public static int getLengthOfLCSTabulationWithSpaceOptimization(String  str1, String  str2)
    {
        int n=str1.length();
        int m=str2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i1=1;i1<=n;i1++){
            for(int i2=1;i2<=m;i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)) curr[i2] = 1 + prev[i2-1];
                else curr[i2] = Math.max(prev[i2], curr[i2-1]);
            }
            prev = curr;
            curr = new int[m+1];
        }
        return prev[m];
    }
}
