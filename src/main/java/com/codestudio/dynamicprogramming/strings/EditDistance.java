package com.codestudio.dynamicprogramming.strings;

//Edit Distance
//https://www.codingninjas.com/studio/problems/edit-distance_630420?leftPanelTab=0
//String Matching DP Striver DP series vid 33
public class EditDistance {
    public static int editDistance(String str1, String str2) {
        return rec(str1.length()-1,str2.length()-1,str1,str2);
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

    public static int editDistanceMem(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(str1.length()-1,str2.length()-1,str1,str2,dp);
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
    public static int editDistanceTabulation(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][] dp = new int[n+1][m+1];

        for(int j=0;j<m+1;j++) dp[0][j] = j;
        for(int i=0;i<n+1;i++) dp[i][0] = i;

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)) {
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
    public static int editDistanceTabWithSpaceOptimization(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int j=0;j<m+1;j++) prev[j] = j;

        for(int i1=1;i1<n+1;i1++){
            curr[0]=i1;   // for every row zeroth column should have i as base case
            for(int i2=1;i2<m+1;i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)) {
                    curr[i2] =  0 + prev[i2-1];
                }else{
                    int delete = 1+prev[i2];
                    int replace = 1+prev[i2-1];
                    int insert = 1+curr[i2-1];

                    curr[i2] = Math.min(delete, Math.min(replace,insert));
                }
            }
            prev=curr;
            curr = new int[m+1];
        }
        return prev[m];
    }

}
