package com.arrays;

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
}
