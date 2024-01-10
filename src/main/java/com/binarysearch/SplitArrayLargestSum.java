package com.binarysearch;

//410. Split Array Largest Sum
//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum {
    //Similar to Allocate books
    class Solution {
        public int splitArray(int[] nums, int k) {
            int low=Integer.MIN_VALUE; // take max val of array because subarray should be containing atleast one element
            int high=0;                 //take total sum because there can be single subarray
            for(int i : nums) {
                high+=i;
                low = Math.max(low, i);
            }

            int minSum=Integer.MAX_VALUE;
            while(low <= high){
                int mid = low +(high-low)/2;

                int arrCount=1;
                int sum=0;
                for(int i=0;i<nums.length;i++){
                    if(sum + nums[i] <= mid){
                        sum+=nums[i];
                    }else {
                        sum=nums[i];
                        arrCount++;
                    }
                }
                if(arrCount == k) minSum = Math.min(minSum, mid);
                if(arrCount <= k) high=mid-1;
                else low=mid+1;
            }
            return low;
        }
    }
}
