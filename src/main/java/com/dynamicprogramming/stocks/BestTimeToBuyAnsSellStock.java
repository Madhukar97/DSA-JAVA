package com.dynamicprogramming.stocks;

import java.util.Arrays;

//121. Best Time to Buy and Sell Stock
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAnsSellStock {
    //Sol using recursion
    public int maxProfit(int[] prices) {
        int profit=0;
        return rec(prices, 0, 0);
    }

    public int rec(int[] prices, int index, int bought){
        if(index == prices.length) return 0;

        if(bought == 0){
            return Math.max(-prices[index] + rec(prices, index+1, 1), 0+rec(prices, index+1, 0));
        }
        return Math.max(prices[index], rec(prices, index+1, 1));
    }
    //Better sol using Recursion and Memoization DP
    public int maxProfitMem(int[] prices) {
        int profit=0;
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return rec(prices, 0, 0, dp);
    }

    public int rec(int[] prices, int index, int bought, int[][] dp){
        if(index == prices.length) return 0;

        if(dp[index][bought] != -1) return dp[index][bought];

        if(bought == 0){
            dp[index][bought] = Math.max(-prices[index] + rec(prices, index+1, 1, dp), 0+rec(prices, index+1, 0, dp));
        }
        else dp[index][bought] = Math.max(prices[index], rec(prices, index+1, 1, dp));
        return dp[index][bought];
    }


    //Optimal sol using prefixMin
    public int maxProfitSol3(int[] prices) {
        int prefixMin  = Integer.MAX_VALUE;
        int profit = 0;

        for(int p : prices){
            profit = Math.max(profit, p-prefixMin);
            prefixMin  = Math.min(prefixMin ,p);
        }
        return profit;
    }
}
