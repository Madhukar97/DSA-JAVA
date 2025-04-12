package com.binarysearch;

//153. Find Minimum in Rotated Sorted Array
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            if(nums[0] < nums[nums.length-1]) return nums[0];
            int s=0;
            int e=nums.length-1;
            int n=nums.length;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(mid-1 >=0 && nums[mid-1] > nums[mid]) return nums[mid];
                if(mid+1 <n && nums[mid] > nums[mid+1]) return nums[mid+1];

                if(nums[s] <= nums[mid]) s=mid+1;
                else e=mid-1;
            }
            return nums[0];
        }
    }
}
