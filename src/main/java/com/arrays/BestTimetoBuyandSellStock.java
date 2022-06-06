package com.arrays;

//121. Best Time to Buy and Sell Stock
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int p : prices) {
            int profit = p-buy;
            if(profit > maxProfit) maxProfit = profit;
            if(p < buy) {
                buy = p;
            }
        }
        return maxProfit;
    }
}
