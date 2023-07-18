package com.codestudio.dynamicprogramming.stocks;

import java.util.ArrayList;

//Best Time to Buy and Sell Stock III
//https://www.codingninjas.com/studio/problems/buy-and-sell-stock_1071012?topic=dynamic-programming&leftPanelTab=0
//Striver DP series vid 37
public class BestTimetoBuyandSellStockIII {
    public static int maxProfit(ArrayList<Integer> prices, int n) {
        return rec(0,1,2,prices);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public static int rec(int i, int buy, int trans, ArrayList<Integer> prices){
        if(i == prices.size() || trans == 0) return 0;

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices.get(i) + rec(i+1,0,trans,prices), 0+rec(i+1,1,trans,prices));
        }else{
            profit = Math.max(prices.get(i) + rec(i+1,1,trans-1,prices), 0+rec(i+1,0,trans,prices));
        }
        return profit;
    }

    public static int maxProfitMem(ArrayList<Integer> prices, int n) {
        int[][][] dp = new int[n][2][2];

        for(int i=0;i<n;i++){
            dp[i][0][0]=-1;
            dp[i][0][1]=-1;
            dp[i][1][0]=-1;
            dp[i][1][1]=-1;
        }

        return recMem(0,1,2,prices,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2*2) , SC = O(n) + dp[n][2][2]
    public static int recMem(int i, int buy, int trans, ArrayList<Integer> prices, int[][][] dp){
        if(i == prices.size() || trans == 0) return 0;

        if(dp[i][buy][trans-1] != -1) return dp[i][buy][trans-1];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices.get(i) + recMem(i+1,0,trans,prices,dp), 0+recMem(i+1,1,trans,prices,dp));
        }else{
            profit = Math.max(prices.get(i) + recMem(i+1,1,trans-1,prices,dp), 0+recMem(i+1,0,trans,prices,dp));
        }
        dp[i][buy][trans-1] = profit;
        return dp[i][buy][trans-1];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*2*2) , SC = dp[n+1][2][3]
    public static int maxProfitTabulation(ArrayList<Integer> prices, int n) {
        int[][][] dp = new int[n+1][2][3];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int trans=1;trans<=2;trans++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices.get(i) + dp[i+1][0][trans], 0+dp[i+1][1][trans]);
                    }else{
                        profit = Math.max(prices.get(i) + dp[i+1][1][trans-1], 0+dp[i+1][0][trans]);
                    }
                    dp[i][buy][trans] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*2*2) , SC = 2*dp[2][3]
    public static int maxProfitTabulationWithSPaceOptimization(ArrayList<Integer> prices, int n) {
        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];

        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int trans=1;trans<=2;trans++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices.get(i) + prev[0][trans], 0+prev[1][trans]);
                    }else{
                        profit = Math.max(prices.get(i) + prev[1][trans-1], 0+prev[0][trans]);
                    }
                    curr[buy][trans] = profit;
                }
            }
            prev = curr;
            curr = new int[2][3];
        }

        return prev[1][2];
    }
}
