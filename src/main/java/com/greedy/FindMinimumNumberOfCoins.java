package com.greedy;

import java.util.ArrayList;
import java.util.List;

//Find Minimum Number Of Coins
//https://www.codingninjas.com/studio/problems/find-minimum-number-of-coins_975277?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&count=25&page=18&search=&sort_entity=order&sort_order=ASC&leftPanelTab=0
public class FindMinimumNumberOfCoins {
    //Optimal sol with time O(n) and space O(1)
    public static List<Integer> MinimumCoins(int n) {
        List<Integer> ans= new ArrayList<>();
        int[] coins = new int[]{1,2,5,10,20,50,100,500,1000};
        int c=coins.length-1;
        while(n > 0){
            if(n >= coins[c]){
                int noOfCoins = n/coins[c];
                while(noOfCoins > 0){
                    ans.add(coins[c]);
                    noOfCoins--;
                }
                n=n%coins[c];
            }else{
                c--;
            }
        }
        return ans;
    }
}
