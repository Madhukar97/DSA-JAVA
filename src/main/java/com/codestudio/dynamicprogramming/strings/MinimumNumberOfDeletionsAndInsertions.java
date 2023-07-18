package com.codestudio.dynamicprogramming.strings;

//Minimum Number of Deletions and Insertions
//https://www.codingninjas.com/studio/problems/minimum-number-of-deletions-and-insertions_4244510?leftPanelTab=0
public class MinimumNumberOfDeletionsAndInsertions {
    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public static int canYouMake(String str, String ptr) {
        int[][] dp = new int[str.length()+1][ptr.length()+1];

        for(int i1=1;i1<str.length()+1;i1++){
            for(int i2=1;i2<ptr.length()+1;i2++){
                if(i1==0 || i2==0) dp[i1][i2] = 0;
                else if(str.charAt(i1-1) == ptr.charAt(i2-1)) dp[i1][i2] = 1+dp[i1-1][i2-1];
                else dp[i1][i2] = Math.max(dp[i1-1][i2], dp[i1][i2-1]);
            }
        }
        return str.length()+ptr.length()-2*dp[str.length()][ptr.length()];
    }
}
