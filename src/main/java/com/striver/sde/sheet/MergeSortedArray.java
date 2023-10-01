package com.striver.sde.sheet;

//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/description/
public class MergeSortedArray {
    //Most optimal solution with Time O(m+n) and space O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(i >= 0 && j >=0){
            if(nums1[i] <= nums2[j]){
                nums1[k] = nums2[j];
                k--;
                j--;
            }else{
                nums1[k] = nums1[i];
                k--;
                i--;
            }
        }

        while(j >= 0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}
