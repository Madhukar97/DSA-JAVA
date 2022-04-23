package com.arrays;

//154. Find Minimum in Rotated Sorted Array II
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class FindMinInRotatedSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(findMin(nums));
    }
    public static int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
    static int binarySearch(int[] nums, int s, int e) {
        if(s>e) return nums[0];
        while(s<e && nums[s] == nums[s+1]) {
            s++;
        }
        while(s<e && nums[e] == nums[e-1]) {
            e--;
        }
        int mid = s + (e-s)/2;
        if(mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
        if(mid < nums.length-1 && nums[mid] > nums[mid+1]) return nums[mid+1];

        return Math.min(binarySearch(nums, s, mid-1), binarySearch(nums, mid+1, e));
    }
}
