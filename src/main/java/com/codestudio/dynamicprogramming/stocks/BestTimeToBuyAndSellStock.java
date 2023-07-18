package com.codestudio.dynamicprogramming.stocks;

import java.util.ArrayList;

//Best Time to Buy and Sell Stock
//https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_893405?leftPanelTab=0
public class BestTimeToBuyAndSellStock {
    //DP Solution
    public static int maximumProfitDP(ArrayList<Integer> prices){
        int min = prices.get(0);
        int profit=0;
        for(int i=1;i<prices.size();i++){
            int trade = prices.get(i)-min;
            profit = Math.max(profit,trade);
            min = Math.min(min, prices.get(i));
        }
        return profit;
    }

    public static int maximumProfit(ArrayList<Integer> prices){
        return rec(0, 1, prices);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public static int rec(int i, int buy, ArrayList<Integer> prices){
        //base case
        if(i == prices.size()) return 0;

        int profit = 0;
        //all possibilities
        if(buy==1){
            int notPick = 0 + rec(i+1,1,prices);
            int pick = -prices.get(i) + rec(i+1,0,prices);
            profit = Math.max(notPick,pick);
        }else{
            int notSell = 0 + rec(i+1,0,prices);
            int sell = prices.get(i) + rec(prices.size(),0,prices);
            profit = Math.max(notSell,sell);
        }
        return profit;
    }

    public static int maximumProfitMem(ArrayList<Integer> prices){
        int[][] dp = new int[prices.size()][2];

        for(int i=0;i<prices.size();i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }

        return recMem(0, 1, prices, dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*2) , SC = O(n) + dp[n][2]
    public static int recMem(int i, int buy, ArrayList<Integer> prices, int[][] dp){
        //base case
        if(i == prices.size()) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        //all possibilities
        if(buy==1){
            int notPick = 0 + recMem(i+1,1,prices,dp);
            int pick = -prices.get(i) + recMem(i+1,0,prices,dp);
            profit = Math.max(notPick,pick);
        }else{
            int notSell = 0 + recMem(i+1,0,prices,dp);
            int sell = prices.get(i) + recMem(prices.size(),0,prices,dp);
            profit = Math.max(notSell,sell);
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*2) , SC = dp[n+1][2]
    public static int maximumProfitTabulation(ArrayList<Integer> prices){
        int[][] dp = new int[prices.size()+1][2];

        for(int i=prices.size()-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    int notPick = 0 + dp[i+1][1];
                    int pick = -prices.get(i) + dp[i+1][0];
                    profit = Math.max(notPick,pick);
                }else{
                    int notSell = 0 + dp[i+1][0];
                    int sell = prices.get(i) + dp[prices.size()][0];;
                    profit = Math.max(notSell,sell);
                }
                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*2) , SC = 2*dp[2]
    public static int maximumProfitTabWithSpaceOptimization(ArrayList<Integer> prices){
        int[] prev = new int[2];
        int[] curr = new int[2];

        for(int i=prices.size()-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    int notPick = 0 + prev[1];
                    int pick = -prices.get(i) + prev[0];
                    profit = Math.max(notPick,pick);
                }else{
                    int notSell = 0 + prev[0];
                    int sell = prices.get(i) + 0;;
                    profit = Math.max(notSell,sell);
                }
                curr[buy] = profit;
            }
            prev=curr;
            curr=new int[2];
        }

        return prev[1];
    }
    //Tabulation(Bottom-up approach) with 1 Array space optimization solution TC = O(n*2) , SC = dp[2]
    public static int maximumProfitTabWithSingleArraySpaceOpt(ArrayList<Integer> prices){
        int[] prev = new int[2];

        for(int i=prices.size()-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++){
                int profit = 0;
                if(buy==1){
                    int notPick = 0 + prev[1];
                    int pick = -prices.get(i) + prev[0];
                    profit = Math.max(notPick,pick);
                }else{
                    int notSell = 0 + prev[0];
                    int sell = prices.get(i) + 0;;
                    profit = Math.max(notSell,sell);
                }
                prev[buy] = profit;
            }
        }

        return prev[1];
    }
}
