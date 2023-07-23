package com.dynamicprogramming.lis;

import java.util.Arrays;
import java.util.Comparator;

//1048. Longest String Chain
//https://leetcode.com/problems/longest-string-chain/description/
//Striver DP series 45
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        int n=words.length;
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++) dp[i]=0;

        Arrays.sort(words, Comparator.comparing(s -> s.length()));

        int maxi=0;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<i;j++){
                if(j==0 || words[i-1].length() == words[j-1].length()+1 && check(words[i-1], words[j-1]) ){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                    maxi=Math.max(maxi,dp[i]);
                }
            }
        }
        return maxi;
    }
    //Special solution DP(Bottom-up approach) with DP solution TC = O(n*n) , SC = dp[n+1]
    public boolean check(String s1, String s2){
        // System.out.println(s1 + ", " + s2);
        int i1=0;
        int i2=0;

        while(i1 < s1.length()){
            if(i2 < s2.length() && s1.charAt(i1) == s2.charAt(i2) ){
                i1+=1;
                i2+=1;
            }else{
                i1+=1;
            }
        }
        // System.out.println(i1 == s1.length() && i2 == s2.length());
        return i1 == s1.length() && i2 == s2.length();
    }
}
