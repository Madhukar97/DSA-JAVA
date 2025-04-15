package com.binarysearch;

//34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FindFirstAndLastPositionOfElementInSortedArray {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int first = floor(nums, target);
            int last = ceil(nums,target);
            return new int[]{first, last};
        }

        int floor(int[] nums, int target){
            int s=0;
            int e=nums.length-1;
            int index=-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(nums[mid] == target) index=mid;
                if(nums[mid] < target){
                    s=mid+1;
                }else e=mid-1;
            }
            return index;
        }
        int ceil(int[] nums, int target){
            int s=0;
            int e=nums.length-1;
            int index=-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(nums[mid] == target) index=mid;
                if(nums[mid] <= target)s=mid+1;
                else {
                    e=mid-1;
                }
            }
            return index;
        }
    }

    // Revision 5
    class Solution2 {
        public int[] searchRange(int[] nums, int target) {
            int floor = floor(nums, target);
            int ceil = ceil(nums, target);
            return new int[]{floor,ceil};
        }

        private int floor(int[] nums, int target){
            int s=0,e=nums.length-1,index=-1;
            while(s <= e){
                int mid = s+(e-s)/2;
                if(nums[mid] == target) index=mid;
                if(nums[mid] < target){
                    s=mid+1;
                }else e=mid-1;
            }
            return index;
        }
        private int ceil(int[] nums, int target){
            int s=0,e=nums.length-1,index=-1;
            while(s <= e){
                int mid = s+(e-s)/2;
                if(nums[mid] == target) index=mid;
                if(nums[mid] > target){
                    e=mid-1;
                }else s=mid+1;
            }
            return index;
        }
    }
}
