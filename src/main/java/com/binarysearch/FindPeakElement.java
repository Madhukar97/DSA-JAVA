package com.binarysearch;

//162. Find Peak Element
//https://leetcode.com/problems/find-peak-element/description/
public class FindPeakElement {
    public int findPeakElement(int[] arr) {
        if(arr.length==1) return 0;
        if(arr.length<=2 && arr[0] < arr[1]) return 1;
        else if(arr.length<=2 && arr[0] > arr[1]) return 0;
        int peak=0;

        for(int i=0;i<arr.length;i++){
            if(i==0 && arr[i] > arr[i+1]) return i;
            else if(i > 0 && i < arr.length-1 && arr[i-1] < arr[i] && arr[i] > arr[i+1]) return i;
            else if(i==arr.length-1 && arr[i-1] < arr[i]) return i;
        }
        return peak;
    }

    //Revision 2
    //Most optimal sol using BinarySearch
    class Solution {
        public int findPeakElement(int[] nums) {
            int start=0;
            int end=nums.length-1;
            while(start <= end){
                int mid=(start+end)/2;
                int left = mid-1 < 0 ? Integer.MIN_VALUE : nums[mid-1];
                int right = mid+1 == nums.length ? Integer.MIN_VALUE : nums[mid+1];
                if(left < nums[mid] && right < nums[mid]) return mid;
                else if(left > nums[mid]) end=mid-1;
                else start=mid+1;
            }
            return 0;
        }
    }
}