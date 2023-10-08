package com.arrays;

//1095. Find in Mountain Array
//https://leetcode.com/problems/find-in-mountain-array/description/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

 interface MountainArray {
     public int get(int index);
     public int length();
 }
public class FindInMountainArray {
     //Time complexity = O(LOG(N)) & SPace = O(1)
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int ans=-1;
        int l=0;
        int r=mountainArr.length()-1;
        int peak=peakIndexInMountainArray(mountainArr);

        l=0;
        r=peak;
        while(l <= r){
            int mid = l+(r-l)/2;
            int curr = mountainArr.get(mid);

            if(curr == target) return mid;
            else if( target < curr) {
                r=mid-1;
            }else l=mid+1;
        }

        l=peak;
        r=mountainArr.length()-1;
        while(l <= r){
            int mid = l+(r-l)/2;

            int curr = mountainArr.get(mid);
            if(curr == target) return mid;
            else if( target > curr) {
                r=mid-1;
            }else l=mid+1;
        }
        return ans;
    }

    public static int peakIndexInMountainArray (MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr.get(mid) > arr.get(mid + 1)) {
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}
