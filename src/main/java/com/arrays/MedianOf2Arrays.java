package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MedianOf2Arrays {
    public static void main(String[] args) {
        MedianOf2Arrays obj = new MedianOf2Arrays();
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        obj.findMedianSortedArrays(arr1,arr2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] list = new int[nums1.length+nums2.length];
        int i=0;
        for(int n : nums1){
            list[i] = n;
            i++;
        }
        if(nums2.length >0 ) {
            for (int n : nums2) {
                list[i] = n;
                i++;
            }
        }
        Arrays.sort(list);
        if(list.length%2 != 0){
            return list[list.length/2];
        }else
            return ((list[list.length/2-1] + list[list.length/2])*0.5);
    }
}
