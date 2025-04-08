package com.slidingwindowtwopointer;

//1248. Count Number of Nice Subarrays
//https://leetcode.com/problems/count-number-of-nice-subarrays/description/
public class CountNumberOfNiceSubarrays {
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            return countSubArrays(nums, k) - countSubArrays(nums, k-1);
        }

        public int countSubArrays(int[] nums, int k){
            int l=0,r=0,count=0,odds=0;
            while(r < nums.length){
                if(nums[r]%2==1) odds++;
                while(odds > k) if(nums[l++]%2==1) odds--;
                count+=r-l+1;
                r++;
            }
            return count;
        }
    }
}
