package com.binarysearch;

//2594. Minimum Time to Repair Cars
//https://leetcode.com/problems/minimum-time-to-repair-cars/description/
public class MinimumTimeToRepairCars {
    class Solution {
        public long repairCars(int[] ranks, int cars) {
            if(ranks.length == 1) return (long)ranks[0]*(long)cars*(long)cars;
            long min=1;
            long max=0;
            int maxRank = 0;
            for(int r : ranks) maxRank = Math.max(r, maxRank);
            max = maxRank*cars*cars;
            if(max < 0) max = Long.MAX_VALUE;

            while(min <= max){
                long mid = min+(max-min)/2;
                long maxCars = 0;
                for(int r : ranks){
                    maxCars += Math.pow(mid/r, 0.5);
                }
                if(maxCars >= cars) max=mid-1;
                else min=mid+1;
            }
            return min;
        }
    }
}
