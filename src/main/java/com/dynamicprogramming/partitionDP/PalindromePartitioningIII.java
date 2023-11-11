package com.dynamicprogramming.partitionDP;

import java.util.Arrays;

//1278. Palindrome Partitioning III
//https://leetcode.com/problems/palindrome-partitioning-iii/description/
public class PalindromePartitioningIII {
    //Better sol using Recursion and Memoization
    public int palindromePartition(String s, int k) {
        int[][] dp = new int[101][101];
        for(int[] row : dp) Arrays.fill(row,-1);
        return rec(s, 0, k, dp, 0);
    }

    public int rec(String s, int index, int k, int[][] dp, int cuts){
        if(cuts > k) return 101;
        if(index == s.length()){
            return cuts == k ? 0 : 101;
        }
        if(dp[index][cuts] != -1 ) return dp[index][cuts];

        int ans=101;
        for(int i=index;i<s.length();i++){
            ans = Math.min(ans, change(s, index, i) + rec(s, i+1, k, dp, cuts+1));
        }
        dp[index][cuts] = ans;
        return ans;
    }

    public int change(String s, int i, int j){
        int ans=0;
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)) ans++;
        }
        return ans;
    }
}
