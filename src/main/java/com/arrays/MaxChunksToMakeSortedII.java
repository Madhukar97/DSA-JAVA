package com.arrays;

//768. Max Chunks To Make Sorted II
//https://leetcode.com/problems/max-chunks-to-make-sorted-ii/description/
public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        //Intuition : we can only divide/split into chunks when all elements on left are <= all elements on right
        int n=arr.length;
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = arr[0];
        for(int i=1;i<n;i++) prefixMax[i] = Math.max(prefixMax[i-1], arr[i]);

        suffixMin[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--) suffixMin[i] = Math.min(suffixMin[i+1], arr[i]);

        int ans = 1;
        for(int i=0;i<n-1;i++) if(prefixMax[i] <= suffixMin[i+1]) ans++;
        return ans;
    }
}
