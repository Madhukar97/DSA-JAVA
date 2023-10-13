package com.arrays;

//33. Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    static int binarySearch(int[] nums, int target, int s, int e) {
        if(s > e) return -1;
        int mid = s + (e-s)/2;
        if(nums[mid] == target) return mid;
        if(nums[s] < nums[mid] && target >= nums[s] && target < nums[mid]) {
            return binarySearch(nums, target, s, mid-1);
        }if(nums[s] > nums[mid] && target >= nums[s]) {
            return binarySearch(nums, target, s, mid-1);
        }if ( nums[s] > nums[mid] && target < nums[mid]   ) {
            return binarySearch(nums, target, s, mid-1);
        }
        else return binarySearch(nums, target, mid+1, e);
    }
    //Most optimal sol with time O(log(n)) and space O(1)
    //Either left half or right half of array is always sorted in rotated sorted arrays
    //Always compare target in the sorted half of array
    public int searchSol2(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;

        while(s <= e){
            int mid=s+(e-s)/2;
            if(nums[mid] == target) return mid;
            else if(nums[s] <= nums[mid]){
                if(nums[s] <= target && target < nums[mid]) e=mid-1;
                else s=mid+1;
            }
            else{
                if(nums[mid] < target && target <= nums[e]) s=mid+1;
                else e=mid-1;
            }
        }
        return -1;
    }
}
