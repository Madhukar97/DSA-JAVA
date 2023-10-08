package com.codestudio.dynamicprogramming.partitionDP;

//PalindromePartitioningII
//https://www.codingninjas.com/studio/problems/palindrome-partitioning-ll_873266?leftPanelTab=0
//Striver DP series vid 53
public class PalindromePartitioningII {

    //Normal recursion solution with TC = O(4^n)*n and SC = O(n)
    //getting TLE error
    public int minCut(String s) {
        return rec(0,s)-1;
    }

    public int rec(int i, String s){
        if(i == s.length()) return 0;

        int min = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindrome(i, j, s)){
                int cuts = 1 + rec(j+1,s);
                min = Math.min(min, cuts);
            }
        }
        return min;
    }

    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //recursion with memoization solution with TC = O(n*n)*n and SC = O(n) + dp[n+1]
    //accepted
    public int minCutMem(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }

        return recMem(0,s,dp)-1;
    }

    public int recMem(int i, String s, int[] dp){
        if(i == s.length()) return 0;

        if(dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPalindromeMem(i, j, s)){
                int cuts = 1 + recMem(j+1,s,dp);
                min = Math.min(min, cuts);
            }
        }
        dp[i] = min;
        return min;
    }

    public boolean isPalindromeMem(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*n)*n , SC = dp[n+1]
    public int minCutTabulation(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        for(int i=n-1;i>=0;i--){
            int min = Integer.MAX_VALUE;
            for(int j=i;j<s.length();j++){
                if(isPalindromeTabulation(i, j, s)){
                    int cuts = 1 + dp[j+1];
                    min = Math.min(min, cuts);
                }
            }
            dp[i] = min;
        }

        return dp[0]-1;
    }

    public boolean isPalindromeTabulation(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
