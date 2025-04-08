package com.slidingwindowtwopointer;

//930. Binary Subarrays With Sum
//https://leetcode.com/problems/binary-subarrays-with-sum/description/
public class BinarySubarraysWithSum {
    class Solution {
        public int numSubarraysWithSum(int[] nums, int goal) {
            return findSubArrays(nums, goal) - findSubArrays(nums, goal-1);
        }

        public int findSubArrays(int[] nums, int goal){
            if(goal < 0) return 0;
            int count=0;
            int l=0,r=0,sum=0;

            while(r < nums.length){
                sum+=nums[r];
                while(sum > goal) sum-=nums[l++];
                count+=r-l+1;
                r++;
            }
            return count;
        }
    }
}
