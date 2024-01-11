package com.binarysearch;

//2064. Minimized Maximum of Products Distributed to Any Store
//https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/
public class MinimizedMaximumOfProductsDistributedToAnyStore {
    class Solution {
        public int minimizedMaximum(int n, int[] quantities) {
            int low =1;
            int high = 100000;

            int minX=Integer.MAX_VALUE;
            while(low <= high){
                int mid = low + (high-low)/2;

                int stores=0;
                for(int i=0;i<quantities.length;i++){
                    if(quantities[i]%mid == 0) stores+=quantities[i]/mid;
                    else stores+=quantities[i]/mid+1;
                }
                if(stores <= n) minX = Math.min(minX, mid);
                if(stores <= n) high=mid-1;
                else low = mid+1;
            }
            return minX;
        }
    }
}
