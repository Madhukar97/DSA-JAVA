package com.dynamicprogramming.strings;

//583. Delete Operation for Two Strings
//https://leetcode.com/problems/delete-operation-for-two-strings/description/
public class DeleteOperationforTwoStrings {
    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for(int i1=1;i1<word1.length()+1;i1++){
            for(int i2=1;i2<word2.length()+1;i2++){
                if(i1==0 || i2==0) dp[i1][i2] = 0;
                else if(word1.charAt(i1-1) == word2.charAt(i2-1)) dp[i1][i2] = 1+dp[i1-1][i2-1];
                else dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }
        return word1.length()+word2.length()-2*dp[word1.length()][word2.length()];
    }
}
