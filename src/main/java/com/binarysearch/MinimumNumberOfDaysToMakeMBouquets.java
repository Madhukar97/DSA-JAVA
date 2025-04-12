package com.binarysearch;

//1482. Minimum Number of Days to Make m Bouquets
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
public class MinimumNumberOfDaysToMakeMBouquets {
    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            int start=1;
            int end=0;
            for(int day : bloomDay) end=Math.max(end, day);

            int minDays = Integer.MAX_VALUE;
            while(start <= end){
                int mid = start+(end-start)/2;
                int bouquets=0;
                int adj=0;
                for(int i=0;i<bloomDay.length;i++){
                    if(bloomDay[i] <= mid){
                        adj++;
                    }else{
                        adj=0;
                    }
                    if(adj == k){
                        bouquets++;
                        adj=0;
                    }
                }
                // System.out.println("DAYS : " + mid+", bouquets : " + bouquets);
                if(bouquets >= m) minDays = Math.min(minDays, mid);
                if(bouquets >= m) end = mid-1;
                else start = mid+1;
            }
            return minDays == Integer.MAX_VALUE ? -1 : minDays;
        }
    }
}
