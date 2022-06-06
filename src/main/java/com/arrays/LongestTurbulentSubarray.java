package com.arrays;

//978. Longest Turbulent Subarray
//https://leetcode.com/problems/longest-turbulent-subarray/
public class LongestTurbulentSubarray {
    public static void main(String[] args) {

    }
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 1) return 1;
        if(arr.length == 2 && arr[0] == arr[1]) return 1;
        int count = 1;
        int max = 1;
        boolean flag = arr[0] > arr[1];

        for(int i=0; i<arr.length-1 ; i++) {
            if(arr[i] == arr[i+1]) {
                count = 1;
                continue;
            }
            //greater
            if(flag) {
                if(arr[i] > arr[i+1]){ count++; flag = !flag;}
                else{
                    count =2 ;
                    flag = true;
                }
            }
            //smaller
            else {
                if(arr[i] < arr[i+1]) {count++; flag = !flag;}
                else{
                    count = 2;
                    flag = false;
                }
            }
            if(count > max) max = count;
        }
        return max;
    }
}
