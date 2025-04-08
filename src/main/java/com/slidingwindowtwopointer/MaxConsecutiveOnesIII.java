package com.slidingwindowtwopointer;

//1004. Max Consecutive Ones III
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class MaxConsecutiveOnesIII {
    //Optimal sol using sliding window
    class Solution {
        public int longestOnes(int[] nums, int k) {
            int count=0;
            int max=0;
            int s=0;
            int e=0;

            while(e < nums.length){
                if(nums[e] == 0){
                    count++;
                }

                while(count > k){
                    if(nums[s] == 0) count--;
                    s++;
                }
                max = Math.max(max, e-s+1);
                e++;
            }
            return max;
        }
    }

    //Sol2 using sliding window
    class Solution2 {
        public int longestOnes(int[] nums, int k) {
            int i=0;
            int j=0;
            while(j < nums.length){
                if(nums[j] == 0) k--;
                if(k < 0 && nums[i++] == 0) k++;
                j++;
            }
            return j-i;
        }
    }

    // Revision 5 TC = O(2N)
    class Solution5 {
        public int longestOnes(int[] nums, int k) {
            int l=0,r=0,maxLength=0,zeros=0;
            while(r<nums.length){
                if(nums[r] == 0) {
                    zeros++;
                    while(zeros > k)if(nums[l++] == 0) zeros--;
                }
                maxLength = Math.max(maxLength, r-l+1);
                r++;
            }
            return maxLength;
        }
    }
}
