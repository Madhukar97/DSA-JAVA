package com.dynamicprogramming.strings;

//115. Distinct Subsequences
//https://leetcode.com/problems/distinct-subsequences/
//Striver DP series vid 32
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        return rec(s.length()-1,t.length()-1,s,t);
    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    public int rec(int i1, int i2, String s, String t){
        if(i2 < 0) return 1;
        if(i1 < 0) return 0;

        if(s.charAt(i1) == t.charAt(i2)) {
            return rec(i1-1,i2-1,s,t) + rec(i1-1,i2,s,t);
        }else return rec(i1-1,i2,s,t);
    }

    public int numDistinctMem(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp = new int[n][m];
        for(int i1=0;i1<n;i1++){
            for(int i2=0;i2<m;i2++){
                dp[i1][i2] = -1;
            }
        }

        recMem(s.length()-1,t.length()-1,s,t,dp);
        return dp[n-1][m-1];
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public int recMem(int i1, int i2, String s, String t, int[][] dp){
        if(i2 < 0) return 1;
        if(i1 < 0) return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];

        if(s.charAt(i1) == t.charAt(i2)) {
            dp[i1][i2]= recMem(i1-1,i2-1,s,t,dp) + recMem(i1-1,i2,s,t,dp);
            return dp[i1][i2];
        }
        else{
            dp[i1][i2]= recMem(i1-1,i2,s,t,dp);
            return dp[i1][i2];
        }
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public int numDistinctTabulation(String s, String t) {
        int n=s.length();
        int m=t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n+1;i++)  dp[i][0] = 1;
        for(int j=1;j<m+1;j++)  dp[0][j] = 0;

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(s.charAt(i1-1) == t.charAt(i2-1)) dp[i1][i2]= dp[i1-1][i2-1] + dp[i1-1][i2];
                else dp[i1][i2]= dp[i1-1][i2];
            }
        }
        return dp[n][m];
    }
}
