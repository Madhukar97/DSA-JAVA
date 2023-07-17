package com.dynamicprogramming.strings;

//712. Minimum ASCII Delete Sum for Two Strings
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/
public class MinimumASCIIDeleteSumforTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        return rec(s1.length()-1,s2.length()-1,s1,s2);
    }
    //Normal recursion solution with TC = exponential and SC = O(n+m)
    public int rec(int i1, int i2, String s1, String s2){
        //base case
        if(i1<0) {
            int sum=0;
            for(int c=0;c<=i2;c++){
                sum+=(int)s2.charAt(c);
            }
            return sum;
        }
        if(i2<0) {
            int sum=0;
            for(int c=0;c<=i1;c++){
                sum+=(int)s1.charAt(c);
            }
            return sum;
        }

        //string matching all possibilities
        if(s1.charAt(i1) == s2.charAt(i2)){
            int notDelete = 0 + rec(i1-1,i2-1,s1,s2);
            int delete = (int)s1.charAt(i1) + (int)s2.charAt(i2) + rec(i1-1,i2-1,s1,s2);
            return Math.min(notDelete,delete);
        }
        return Math.min((int)s1.charAt(i1) + rec(i1-1,i2,s1,s2),(int)s2.charAt(i2) + rec(i1,i2-1,s1,s2));
    }

    public int minimumDeleteSumMem(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(s1.length()-1,s2.length()-1,s1,s2,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public int recMem(int i1, int i2, String s1, String s2, int[][] dp){
        //base case
        if(i1<0) {
            int sum=0;
            for(int c=0;c<=i2;c++){
                sum+=(int)s2.charAt(c);
            }
            return sum;
        }
        if(i2<0) {
            int sum=0;
            for(int c=0;c<=i1;c++){
                sum+=(int)s1.charAt(c);
            }
            return sum;
        }

        if(dp[i1][i2] != -1) return dp[i1][i2];

        //string matching all possibilities
        if(s1.charAt(i1) == s2.charAt(i2)){
            int notDelete = 0 + recMem(i1-1,i2-1,s1,s2,dp);
            int delete = (int)s1.charAt(i1) + (int)s2.charAt(i2) + recMem(i1-1,i2-1,s1,s2,dp);
            dp[i1][i2] = Math.min(notDelete,delete);
            return dp[i1][i2];
        }
        dp[i1][i2] = Math.min((int)s1.charAt(i1) + recMem(i1-1,i2,s1,s2,dp),(int)s2.charAt(i2) + recMem(i1,i2-1,s1,s2,dp));
        return dp[i1][i2];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public int minimumDeleteSumTabulation(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int j=1;j<m+1;j++) {
            int sum=0;
            for(int c=1;c<=j;c++){
                sum+=(int)s2.charAt(c-1);
            }
            dp[0][j] = sum;
        }
        for(int i=1;i<n+1;i++) {
            int sum=0;
            for(int c=1;c<=i;c++){
                sum+=(int)s1.charAt(c-1);
            }
            dp[i][0] = sum;
        }

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(s1.charAt(i1-1) == s2.charAt(i2-1)){
                    int notDelete = 0 + dp[i1-1][i2-1];
                    int delete = (int)s1.charAt(i1-1) + (int)s2.charAt(i2-1) + dp[i1-1][i2-1];
                    dp[i1][i2] = Math.min(notDelete,delete);
                }else {
                    dp[i1][i2] = Math.min((int)s1.charAt(i1-1) + dp[i1-1][i2], (int)s2.charAt(i2-1) + dp[i1][i2-1]);
                }
            }
        }
        return dp[n][m];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*m) , SC = 2*dp[m+1]
    public int minimumDeleteSumTabWithSpaceOptimization(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int j=1;j<m+1;j++) {
            int sum=0;
            for(int c=1;c<=j;c++){
                sum+=(int)s2.charAt(c-1);
            }
            prev[j] = sum;
        }

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                //for every row 1st column should have the char sum from 0->i
                int sum=0;
                for(int c=1;c<=i1;c++){
                    sum+=(int)s1.charAt(c-1);
                }
                curr[0] = sum;

                if(s1.charAt(i1-1) == s2.charAt(i2-1)){
                    int notDelete = 0 + prev[i2-1];
                    int delete = (int)s1.charAt(i1-1) + (int)s2.charAt(i2-1) + prev[i2-1];
                    curr[i2] = Math.min(notDelete,delete);
                }else {
                    curr[i2] = Math.min((int)s1.charAt(i1-1) + prev[i2], (int)s2.charAt(i2-1) + curr[i2-1]);
                }
            }
            prev=curr;
            curr = new int[m+1];
        }
        return prev[m];
    }
}
