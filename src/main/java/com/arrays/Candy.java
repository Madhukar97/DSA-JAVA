package com.arrays;

import java.util.Arrays;

//135. Candy
//https://leetcode.com/problems/candy/description/
public class Candy {
    //Most Optimal Solution using left and right pass with TC = O(n) and SC = O(1)
    public int candy(int[] ratings) {
        int n= ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for(int i=0;i<n;i++){
            if(i-1 >= 0 && ratings[i-1] < ratings[i]){
                candies[i]=candies[i-1]+1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i-1 >= 0 && ratings[i-1] > ratings[i]){
                if(candies[i-1] <= candies[i]){
                    candies[i-1]=candies[i]+1;
                }
            }
        }

        int count=0;
        for(int i : candies) count+=i;
        return count;
    }
}
