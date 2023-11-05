package com.dynamicprogramming.partitionDP;

import java.util.*;

//139. Word Break
//leetcode.com/problems/word-break/description/
public class WordBreak {

    //Brute Force using Recursion with TC = O(n^(n-1)) and space O(1)
    public boolean wordBreak(String s, List<String> wordDict) {
        return rec(s, wordDict, 0);
    }

    public boolean rec(String s, List<String> wordDict, int i){
        if(i == s.length()) return true;

        boolean possible = false;
        for(int p=i;p<s.length();p++){
            if(wordDict.contains(s.substring(i,p+1))){
                boolean isPossible = rec(s, wordDict, p+1);
                possible = possible || isPossible;
            }
        }
        return possible;
    }

    //Better sol using Recursion with Memoization
    public boolean wordBreakMem(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return rec(s, wordDict, 0, dp);
    }

    public boolean rec(String s, List<String> wordDict, int i, int[] dp){
        if(i == s.length()) return true;

        if(dp[i] != -1) return dp[i] == 1 ;

        boolean possible = false;
        for(int p=i;p<s.length();p++){
            if(wordDict.contains(s.substring(i,p+1))){
                boolean isPossible = rec(s, wordDict, p+1, dp);
                possible = possible || isPossible;
            }
        }
        dp[i] = possible ? 1 : 0;
        return dp[i]==1;
    }

    //Tabulation
    public boolean wordBreakTabulation(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;

        for(int i=s.length()-1;i>=0;i--){
            boolean possible = false;
            for(int p=i;p<s.length();p++){
                if(wordDict.contains(s.substring(i,p+1))){
                    boolean isPossible = dp[p+1]==1;
                    possible = possible || isPossible;
                }
            }
            dp[i] = possible ? 1 : 0;
        }
        return dp[0]==1;
    }
}
