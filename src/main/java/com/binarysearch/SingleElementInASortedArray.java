package com.binarysearch;

//540. Single Element in a Sorted Array
//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class SingleElementInASortedArray {
    //Optimal sol 1 using binary search
    //search the array based on even or odd indexes nums[i] == nums[i^1] and low will end up just right of the left half
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-2;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == nums[mid^1]){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return nums[left];
    }

    //Optimal sol 2 using binary search
    public int singleNonDuplicateSol2(int[] nums) {
        int n=nums.length;
        int s=0;
        int e=n-1;

        while(s<=e){
            int mid = s+(e-s)/2;
            if(mid%2 == 0){
                if(mid+1 < n && nums[mid] == nums[mid+1]) s=mid+1;
                else if(mid-1 >=0 && nums[mid] != nums[mid-1]) return nums[mid];
                else e=mid-1;
            }else{
                if(mid-1 >= 0 && nums[mid] == nums[mid-1]) s=mid+1;
                else if(mid+1 < n && nums[mid] != nums[mid+1]) return nums[mid];
                else e=mid-1;
            }
        }
        return nums[s];
    }
}
