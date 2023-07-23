package com.arrays;

//852. Peak Index in a Mountain Array
//https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakIndexInAMountainArray {
    //Normal Iteration sol with Time Complexity = O(n)
    public int peakIndexInMountainArray(int[] arr) {
        int peak=0;

        for(int i=1;i<arr.length-1;i++){
            // System.out.println("val :: " + arr[i]);
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) return i;
        }
        return peak;
    }

    //Binary Search sol with Time Complexity = O(log(n))
    public int peakIndexInMountainArrayBinarySearch(int[] arr) {
        int left=1;
        int right=arr.length-2;

        while(left  <= right ){
            int mid = left  + (right-left)/2;
            if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return mid;
            else if(arr[mid-1]<arr[mid] && arr[mid] < arr[mid+1]) left = mid+1;
            else right=mid-1;
        }
        return 0;
    }
}
