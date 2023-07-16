package com.dynamicprogramming.strings;

//1092. Shortest Common Supersequence
//https://leetcode.com/problems/shortest-common-supersequence/description/
public class ShortestCommonSupersequence {
    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(str1.charAt(i1-1) == str2.charAt(i2-1)) dp[i1][i2] = 1+dp[i1-1][i2-1];
                else dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }

        String lcs="";
        int i=n;
        int j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                lcs = str1.charAt(i-1) + lcs;
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                lcs = str1.charAt(i-1) + lcs;
                i--;
            }else {
                lcs = str2.charAt(j-1) + lcs;
                j--;
            }

        }

        while(i>0) {
            lcs = str1.charAt(i-1) + lcs;
            i--;
        }
        while(j>0) {
            lcs = str2.charAt(j-1) + lcs;
            j--;
        }
        return lcs;
    }
}
