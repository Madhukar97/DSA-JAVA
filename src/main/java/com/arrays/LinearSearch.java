package com.arrays;

// Linear Search
//https://www.naukri.com/code360/problems/linear-search_624470?leftPanelTabValue=PROBLEM
public class LinearSearch {
    public static int linearSearch(int arr[], int x) {
        //Your code goes here
        int n=arr.length;
        for(int i=0;i<n;i++) if(arr[i] == x) return i;
        return -1;
    }
}
