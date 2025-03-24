package com.binarysearch;

//https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
public class MaximumCountofPositiveIntegerandNegativeInteger {
    class Solution {
        public int maximumCount(int[] nums) {
            int n=nums.length;
            int ub = upperBound(nums, 0);
            int lb = lowerBound(nums, 0);
            // System.out.println("ub : " + ub + ", lb : " + lb);
            int pos = n-ub;     // All integers from the first non-zero to last will be positive
            int neg = lb;       // All integers from the index 0 to index before the first zero index will be negative.
            if(nums[0] == 0 && nums[n-1] == 0) return 0;
            return Math.max(pos, neg);
        }
        // Return the first index where the value is greater than target.
        int upperBound(int[] arr, int target){
            int s=0;
            int e=arr.length-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] <= target) s=mid+1;
                else {
                    e=mid-1;
                }
            }
            return s;
        }
        // Return the first index where the value is equal to or greater than target.
        int lowerBound(int[] arr, int target){
            int s=0;
            int e=arr.length-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] < target) s=mid+1;
                else e=mid-1;
            }
            return s;
        }
    }
}
