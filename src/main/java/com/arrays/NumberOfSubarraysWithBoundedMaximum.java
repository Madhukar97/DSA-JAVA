package com.arrays;

//795. Number of Subarrays with Bounded Maximum
//https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
public class NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        //Intuition for subArray : Sliding window
        int i=0;
        int prevCount=0;
        int count=0;

        for(int j=0;j<nums.length;j++){
            if(nums[j] >= left && nums[j] <= right){
                count += j-i+1;
                prevCount = j-i+1;
            }else if(nums[j] <= right){
                count+=prevCount;
            }else{
                prevCount=0;
                i=j+1;
            }
        }
        return count;
    }
}
