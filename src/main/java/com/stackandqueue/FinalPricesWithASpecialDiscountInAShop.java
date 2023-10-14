package com.stackandqueue;

import java.util.Stack;

//1475. Final Prices With a Special Discount in a Shop
//Next Smaller Element
//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
//https://www.codingninjas.com/studio/problems/next-smaller-element_1112581?leftPanelTab=1
public class FinalPricesWithASpecialDiscountInAShop {
    //Optimal sol using stack with time O(n) and space O(n)
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i]=prices[i];
            }else{
                nse[i]=prices[i]-stack.peek();
            }
            stack.push(prices[i]);
        }
        return nse;
    }
}
