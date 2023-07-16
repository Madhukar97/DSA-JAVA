package com.codestudio.dynamicprogramming.strings;

//Longest Palindromic Subsequence
//https://www.codingninjas.com/studio/problems/longest-palindromic-subsequence_842787
//Striver DP series vid 28
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "1234567";
        String rev = "";
        for(int i=s.length()-1;i>=0;i--){
            rev = rev + s.charAt(i);
            System.out.println("curr rev :: " + rev);
        }
        System.out.println("rev::"+rev);
    }
    public static int longestPalindromeSubsequence(String s) {
        return rec(s.length()-1,0,s);
    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    public static int rec(int i1, int i2, String s){
        if( i1<0 || i2 == s.length()) return 0;

        if(s.charAt(i1) == s.charAt(i2)) return 1+rec(i1-1,i2+1,s);
        return Math.max(rec(i1-1,i2,s), rec(i1,i2+1,s));
    }

    public static int longestPalindromeSubsequenceMem(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i][j] = -1;
            }
        }
        return recMem(s.length()-1,0,s,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public static int recMem(int i1, int i2, String s, int[][] dp){
        if( i1<0 || i2 == s.length()) return 0;
        if( dp[i1][i2] != -1) return dp[i1][i2];

        if(s.charAt(i1) == s.charAt(i2)) {
            dp[i1][i2] = 1+recMem(i1-1,i2+1,s,dp);
            return dp[i1][i2];
        }
        dp[i1][i2] = Math.max(recMem(i1-1,i2,s,dp), recMem(i1,i2+1,s,dp));
        return dp[i1][i2];
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public static int longestPalindromeSubsequenceTabulation(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        String rev = "";
        for(int i=s.length()-1;i>=0;i--) rev = rev + s.charAt(i);

        for(int i1=1;i1<s.length()+1;i1++){
            for(int i2=1;i2<s.length()+1;i2++){
                if(i1==0 || i2==0) dp[i1][i2] = 0;
                else if(s.charAt(i1-1) == rev.charAt(i2-1)) dp[i1][i2] = 1+dp[i1-1][i2-1];
                else dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }
        return dp[s.length()][s.length()];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*m) , SC = 2*dp[m+1]=
    public static int longestPalindromeSubsequenceTabWithSpaceOptimization(String s) {
        int[] prev = new int[s.length()+1];
        int[] curr = new int[s.length()+1];

        String rev = "";
        for(int i=s.length()-1;i>=0;i--) rev = rev + s.charAt(i);

        for(int i1=1;i1<s.length()+1;i1++){
            for(int i2=1;i2<s.length()+1;i2++){
                if(i1==0 || i2==0) curr[i2] = 0;
                else if(s.charAt(i1-1) == rev.charAt(i2-1)) curr[i2] = 1+prev[i2-1];
                else curr[i2] = Math.max(prev[i2], curr[i2-1]);
            }
            prev = curr;
            curr = new int[s.length()+1];
        }
        return prev[s.length()];
    }

}
