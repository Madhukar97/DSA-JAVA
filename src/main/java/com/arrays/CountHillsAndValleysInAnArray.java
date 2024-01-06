package com.arrays;

//2210. Count Hills and Valleys in an Array
//https://leetcode.com/problems/count-hills-and-valleys-in-an-array/description/
public class CountHillsAndValleysInAnArray {
    class Solution {
        public int countHillValley(int[] nums) {
            int n=nums.length;
            int count = 0;
            for(int i=1;i<n-1;i++){
                int left = i;
                int right = i;
                while(left >= 0 && nums[i] == nums[left]) left--;
                while(right < n && nums[i] == nums[right]) right++;
                if(left>=0 && right<n){
                    if(nums[left] < nums[i] && nums[right] < nums[i]){
                        if(i == 1 ) count++;
                        else if(nums[i] != nums[i-1]) count++;
                    }else if(nums[left] > nums[i] && nums[right] > nums[i]){
                        if(i == 1 ) count++;
                        else if(nums[i] != nums[i-1]) count++;
                    }
                }
            }
            return count;
        }
    }

    //Most optimal sol
    class Solution2 {
        public int countHillValley(int[] nums) {
            int n=nums.length;
            int count = 0;
            int start = nums[0];
            for(int i=1;i<n-1;i++){
                if(start < nums[i] && nums[i] > nums[i+1] || start > nums[i] && nums[i] < nums[i+1]){
                    count++;
                    start = nums[i];
                }
            }
            return count;
        }
    }
}
