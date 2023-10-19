package com.arrays;

//485. Max Consecutive Ones
//https://leetcode.com/problems/max-consecutive-ones/description/
public class MaxConsecutiveOnes {
    //  Optimal sol with time complexity O(n) and space O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        int i=0;
        while(i<nums.length){
            if( nums[i]==1){
                count++;
                maxCount=Math.max(maxCount,count);
            }else{
                count=0;
            }
            i++;
        }
        return maxCount;
    }
}
