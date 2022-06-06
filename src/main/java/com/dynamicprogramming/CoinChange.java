package com.dynamicprogramming;

import java.util.Arrays;

//322. Coin Change
//https://leetcode.com/problems/coin-change/
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        CoinChange obj = new CoinChange();
        int ans = obj.coinChange(coins, 11);
        System.out.println(ans);
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = recFunc(coins, amount, dp);
        // for(int i=0; i<dp.length; i++) {
        //     System.out.println(dp[i]);
        // }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    int recFunc(int[] coins, int amount, int[] dp) {
        if(amount == 0) return 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++) {
            int subAns = 0;
            if(amount-coins[i]  >= 0)  {
                if(dp[amount-coins[i]] != -1) subAns = dp[amount-coins[i]];
                else {
                    subAns = recFunc(coins, amount-coins[i], dp);
                }
                if(subAns != Integer.MAX_VALUE && subAns+1 < ans) ans = subAns+1;
            }
        }
        dp[amount] = ans;
        return ans;
    }
}
