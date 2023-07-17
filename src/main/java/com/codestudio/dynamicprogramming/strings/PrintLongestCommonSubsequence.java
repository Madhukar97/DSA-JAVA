package com.codestudio.dynamicprogramming.strings;

//Print Longest Common Subsequence
//https://www.codingninjas.com/studio/problems/print-longest-common-subsequence_8416383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class PrintLongestCommonSubsequence {
    public static String findLCS(int n, int m, String s1, String s2){
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        rec(n-1,m-1,s1,s2,dp);

        String ans = "";

        int i=n-1;
        int j=m-1;

        while(i>0 && j>0){
            if(s1.charAt(i) == s2.charAt(j)){
                ans= s1.charAt(i) + ans;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
        return ans;

    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public static int rec(int i1, int i2, String s1, String s2, int[][] dp){
        //base case
        if(i1<0 || i2<0) return 0;

        if(dp[i1][i2] != -1) return dp[i1][i2];

        //lcs all possibilities
        if(s1.charAt(i1) == s2.charAt(i2)){
            dp[i1][i2] = 1+rec(i1-1,i2-1,s1,s2,dp);
            return dp[i1][i2];
        }
        dp[i1][i2] = Math.max(rec(i1-1,i2,s1,s2,dp), rec(i1,i2-1,s1,s2,dp));
        return dp[i1][i2];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public static String findLCSTabulation(int n, int m, String s1, String s2){
        int[][] dp = new int[n+1][m+1];

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(s1.charAt(i1-1) == s2.charAt(i2-1)){
                    dp[i1][i2] = 1+dp[i1-1][i2-1];
                }
                else{
                    dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
                }
            }
        }

        String ans = "";
        int i=n;
        int j=m;

        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                ans= s1.charAt(i-1) + ans;
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }else {
                j--;
            }
        }
        return ans;
    }
}
