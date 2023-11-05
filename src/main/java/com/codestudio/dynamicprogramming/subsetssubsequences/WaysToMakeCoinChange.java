package com.codestudio.dynamicprogramming.subsetssubsequences;

import java.util.Arrays;

//Ways To Make Coin Change
//https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
//https://leetcode.com/problems/coin-change/
//https://leetcode.com/problems/coin-change-ii/description/
public class WaysToMakeCoinChange {

    //Recursion with Memoization
    public static long countWaysToMakeChange(int denominations[], int value){
        long[][] dp = new long[denominations.length][value+1];
        for(long[] row : dp) Arrays.fill(row,-1);

        return rec(denominations,denominations.length-1,value,dp);
    }

    public static long rec(int[] coins, int i, int amount, long[][] dp){
        if(amount == 0) return 1;
        if(i < 0) return 0;

        if(dp[i][amount] != -1) return dp[i][amount];

        if(coins[i] <= amount){
            long pick = rec(coins, i, amount-coins[i],dp);
            long notPick = rec(coins, i-1, amount,dp);

            dp[i][amount] = pick+notPick;
            return dp[i][amount];
        }
        dp[i][amount] = rec(coins, i-1, amount,dp);
        return dp[i][amount];
    }

    //Tabulation
    public int countWaysToMakeChange(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int j=0;j<=amount;j++) if(j%coins[0] == 0) dp[0][j] = 1;

        for(int i=1;i<coins.length;i++){
            for(int target=0;target<=amount;target++){
                if(coins[i] <= target){
                    int pick = dp[i][target-coins[i]];
                    int notPick = dp[i-1][target];

                    dp[i][target] = pick+notPick;
                }
                else dp[i][target] = dp[i-1][target];
            }
        }
        return dp[coins.length-1][amount];
    }
}
