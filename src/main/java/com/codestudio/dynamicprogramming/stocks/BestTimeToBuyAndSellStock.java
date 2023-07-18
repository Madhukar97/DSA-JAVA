package com.codestudio.dynamicprogramming.stocks;

import java.util.ArrayList;

//Best Time to Buy and Sell Stock
//https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_893405?leftPanelTab=0
public class BestTimeToBuyAndSellStock {
    //DP Solution
    public static int maximumProfit(ArrayList<Integer> prices){
        int min = prices.get(0);
        int profit=0;
        for(int i=1;i<prices.size();i++){
            int trade = prices.get(i)-min;
            profit = Math.max(profit,trade);
            min = Math.min(min, prices.get(i));
        }
        return profit;
    }
}
