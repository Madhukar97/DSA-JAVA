package com.binarysearch;

//1011. Capacity To Ship Packages Within D Days
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class CapacityToShipPackagesWithinDDays {
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int low=1;
            int high=0;
            for(int i=0;i<weights.length;i++) high+=weights[i];

            int minCap=Integer.MAX_VALUE;
            while(low <= high){
                int mid = low+(high-low)/2;

                int day=1;
                int capacity=0;
                for(int i=0;i<weights.length;i++){
                    if(capacity + weights[i] <= mid){
                        capacity+=weights[i];
                    }else if(weights[i] <= mid){
                        capacity=weights[i];
                        day++;
                    }else {
                        day=Integer.MAX_VALUE;
                        break;
                    }
                }
                // System.out.println("DAYS : " + day +", capacity : " + mid);
                if(day <= days) minCap=Math.min(minCap, mid);
                if(day <= days) high = mid-1;
                else low = mid+1;
            }
            return minCap;
        }
    }

    // Revision 5
    class Solution2 {
        public int shipWithinDays(int[] weights, int days) {
            int min=1;
            int max=0;
            for(int wt : weights) {
                max+=wt;
                min=Math.max(min,wt);
            }

            while(min<=max){
                int mid = min+(max-min)/2;
                int totalDays = 0;
                int totalWt=0;
                for(int wt : weights){
                    totalWt += wt;
                    if(totalWt > mid){
                        totalDays++;
                        totalWt = wt;
                    }
                }
                if(totalWt > 0) totalDays++;
                if(totalDays <= days) max=mid-1;
                else min=mid+1;
            }
            return min;
        }
    }
}
