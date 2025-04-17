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

    // Revision 5
    class Solution2 {
        public int minDays(int[] bloomDay, int m, int k) {
            int n=bloomDay.length;
            int min=1;
            int max=0;
            for(int d : bloomDay) max = Math.max(max, d);
            int maxDays=max;
            while(min <= max){
                int mid = max-(max-min)/2;
                int boqs = 0;
                int flows = 0;
                for(int i=0;i<n;i++){
                    if(bloomDay[i] <= mid) flows++;
                    else flows=0;
                    if(flows == k) {
                        boqs++;
                        flows=0;
                    }
                }
                if(boqs >= m) max=mid-1;
                else min=mid+1;
            }
            return min > maxDays ? -1 : min; // if no ans is possible the min will end up right of max which is max+1 {1........10} min=11
        }
    }
}
