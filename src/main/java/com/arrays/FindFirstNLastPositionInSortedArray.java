package com.arrays;

import java.util.Arrays;

//34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//solve in O(logn) time
public class FindFirstNLastPositionInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int[] nums1 = {2,2};
        int[] nums2 = {5,7,7,8,8,10};
        int[] nums3 = {1,2,3,3,3,3,4,5,9};
        System.out.println(Arrays.toString(searchRange2(nums, 2)));
        System.out.println(Arrays.toString(searchRange2(nums1, 2)));
        System.out.println(Arrays.toString(searchRange2(nums2, 7)));
        System.out.println(Arrays.toString(searchRange2(nums3, 3)));
    }

    //linear search brute force solution
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int[] ans = {-1,-1};
        int s = 0;
        int e = nums.length-1;
        while(s < e && nums[s] != target) {
            s++;
        }
        while(s < e && nums[e] != target) {
            e--;
        }
        ans[0] = s;
        ans[1] = e;
        if(nums[s] != target || nums[e] != target) return new int[]{-1,-1};
        return ans;
    }

    //binarySearch solution O(log(n))
    static int[] searchRange2(int[] nums, int target) {
        int[] ans = {-1,-1};
        int mid = binarySearch(nums, target, 0, nums.length-1);
        if(mid == -1) return ans;
        int s=mid;
        int e=mid;
        while(s>0 && nums[s-1] == target) {
            s--;
        }
        while(e<nums.length-1 && nums[e+1] == target){
            e++;
        }
        ans[0] = s;
        ans[1] = e;
        return ans;
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = start + (end - start)/2;
        if (start > end) return -1;
        if (target == arr[mid]) return mid;
        if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid-1);
        }
        else return binarySearch(arr, target, mid+1, end);
    }
}
