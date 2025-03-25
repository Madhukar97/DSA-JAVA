package com.binarysearch;

//81. Search in Rotated Sorted Array II
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
public class SearchInRotatedSortedArrayII {
    class Solution {
        public boolean search(int[] nums, int target) {
            int s=0;
            int e=nums.length-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(nums[mid] == target) return true;
                if(nums[s] == nums[mid] && nums[mid] == nums[e]){
                    s++;
                    e--;
                }
                else if(nums[s] <= nums[mid]){
                    if(nums[s] <= target && target < nums[mid]) e=mid-1;
                    else s=mid+1;
                }else {
                    if(nums[mid] < target && target <= nums[e]) s=mid+1;
                    else e=mid-1;
                }
            }
            return false;
        }
    }
}
