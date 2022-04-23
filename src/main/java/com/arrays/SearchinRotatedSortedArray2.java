package com.arrays;

//81. Search in Rotated Sorted Array II
//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchinRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        System.out.println(search(nums, 2));
    }
    public static boolean search(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length-1);
        if(index == -1) return false;
        return true;
    }
    static int binarySearch(int[] nums, int target, int s, int e) {
        if(s > e) return -1;
        while(s<e && nums[s] == nums[s+1]) {
            s++;
        }
        while(s<e && nums[e] == nums[e-1]) {
            e--;
        }
        int mid = s + (e-s)/2;
        if(nums[mid] == target) return mid;
        if(nums[s] == target) return s;
        if(nums[e] == target) return e;
        if(nums[s] <= nums[mid] && target >= nums[s] && target < nums[mid]) {
            return binarySearch(nums, target, s, mid-1);
        }if(nums[s] >= nums[mid] && target >= nums[s]) {
            return binarySearch(nums, target, s, mid-1);
        }if ( nums[s] >= nums[mid] && target < nums[mid]   ) {
            return binarySearch(nums, target, s, mid-1);
        }
        else return binarySearch(nums, target, mid+1, e);
    }
}
