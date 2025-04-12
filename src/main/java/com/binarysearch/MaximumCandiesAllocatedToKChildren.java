package com.binarysearch;

//2226. Maximum Candies Allocated to K Children
//https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
public class MaximumCandiesAllocatedToKChildren {
    class Solution {
        public int maximumCandies(int[] candies, long k) {
            int low=1;
            int high=0;
            long total=0;
            for(int c : candies) {
                high = Math.max(high, c);
                total+=c;
            }
            if(total < k) return 0;

            int maxCandies=Integer.MIN_VALUE;
            while(low <= high){
                int mid = low + (high-low)/2;

                long childs=0;
                for(int i=0;i<candies.length;i++){
                    if(candies[i] >= mid){
                        childs+= candies[i]/mid;
                    }
                }
                // System.out.println("childs : " + childs +", mid : " + mid);
                if(childs >= k) maxCandies = Math.max(maxCandies, mid);
                if(childs >= k) low = mid+1;
                else high=mid-1;
            }
            return maxCandies == Integer.MIN_VALUE ? 0 : maxCandies;
        }
    }
}
