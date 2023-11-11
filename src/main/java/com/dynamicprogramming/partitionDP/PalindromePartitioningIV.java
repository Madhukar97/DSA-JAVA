package com.dynamicprogramming.partitionDP;

import java.util.Arrays;

public class PalindromePartitioningIV {
    public static void main(String[] args) {
        System.out.println("ANS : " + checkPartitioning2("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaxyaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    //Brute force Recursion sol
    public boolean checkPartitioning(String s) {
        return rec(s, 0, 0);
    }

    public boolean rec(String s, int index, int cuts){
        if(index == s.length()){
            return cuts == 3;
        }

        boolean flag=false;
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                flag = flag || rec(s, i+1, cuts+1);
            }
        }
        return flag;
    }

    public boolean isPalindrome(String s, int i, int j){
        while(i<j) if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    //Better sol using DP Memoization
    public static boolean checkPartitioning2(String s) {
        int[][] dp = new int[s.length()][4];
        for(int[] row : dp) Arrays.fill(row, -1);
        return rec(s, 0, 0, dp);
    }

    public static boolean rec(String s, int index, int cuts, int[][] dp){
        if(cuts > 3) return false;
        if(index == s.length()){
            return cuts == 3;
        }

        if(dp[index][cuts] != -1 ) return dp[index][cuts] == 1;

        boolean flag=false;
        for(int i=index;i<s.length();i++){
            if(isPalindrome2(s,index,i)){
                flag = flag || rec(s, i+1, cuts+1, dp);
            }
        }

        dp[index][cuts] = flag ? 1 : 0;
        return flag;
    }

    public static boolean isPalindrome2(String s, int i, int j){
        while(i<j) if(s.charAt(i++) != s.charAt(j--)) return false;
        return true;
    }

    //Most Optimal sol using tabulation
    public boolean checkPartitioningTabulation(String s) {
        int n=s.length();
        boolean[][] dp = new boolean[n][n];

        //build up DP table
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = (i+1 <= j-1) ? dp[i+1][j-1] : true;
                else dp[i][j] = false;
            }
        }

        //iterate every mid and check left,mid,right are pals or not
        for(int i=1;i<n-1;i++){
            for(int j=i;j<n-1;j++){
                if(dp[0][i-1] && dp[i][j] && dp[j+1][n-1]) return true;
            }
        }
        return false;
    }
}
