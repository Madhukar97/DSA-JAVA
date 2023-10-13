package com.arrays;

import java.util.Arrays;

//4. Median of Two Sorted Arrays
//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
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

    //Most optimized sol using binary search with time o(min(n1,n2)) and space O(1)
    public double findMedianSortedArraysSol2(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n2 < n1) return findMedianSortedArraysSol2(nums2,nums1);
        int s=0;
        int e=n1;
        int total = n1+n2;

        while(s <= e){
            int mid1 = (s+e)/2;
            int mid2 = (total+1)/2 - mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            if(mid1-1 >=0) l1=nums1[mid1-1];
            if(mid2-1 >=0) l2=nums2[mid2-1];
            if(mid1 < n1) r1=nums1[mid1];
            if(mid2 < n2) r2=nums2[mid2];
            if(l1 <= r2 && l2 <= r1){
                if(total % 2 == 1) return Math.max(l1,l2);
                else return (double)(Math.max(l1,l2)+Math.min(r1,r2))/(double)2;
            }else if(l1 > r2) e=mid1-1;
            else s=mid1+1;
        }
        return 0;
    }
}
