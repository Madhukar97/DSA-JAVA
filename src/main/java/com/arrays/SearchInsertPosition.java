package com.arrays;

//35. Search Insert Position
//https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(searchInsert(nums, 0));
    }
    public static int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;
        int ans = binarySearch(nums, target, 0 , nums.length-1);
        if(ans >= 0) {
            return ans;
        }
        return binarySearch1(nums, target, 0 , nums.length-1)+1;
    }
    static int binarySearch(int[] nums, int target, int start, int end) {
        int mid = start + (end-start)/2;
        if(start > end) return -1;
        if(nums[mid] == target) return mid;
        if(target < nums[mid]) return binarySearch(nums, target, start, mid-1);
        else return binarySearch(nums, target, mid+1, end);
    }
    static int binarySearch1(int[] nums, int target, int start, int end) {
        int mid = start + (end-start)/2;
        if(mid > 0 && nums[mid] > target && nums[mid-1] < target) return mid-1;
        if(mid < nums.length-1 && nums[mid] < target && nums[mid+1] > target) return mid;
        if(target < nums[mid]) return binarySearch1(nums, target, start, mid-1);
        else return binarySearch1(nums, target, mid+1, end);
    }
}
