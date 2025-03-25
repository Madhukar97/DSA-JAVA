package com.binarysearch;

import java.util.Arrays;

//Ceil The Floor
//https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=ceil-the-floor
public class CeilAndFloor {
    // Ceil and floor is little diff from upper and lower bound
    class Solution {
        public int[] getFloorAndCeil(int x, int[] arr) {
            // code here
            Arrays.sort(arr);
            int floor = floor(arr, x);
            int ceil = ceil(arr, x);
            return new int[]{floor, ceil};
        }
        // Element less than or equal to target
        // Note : whereas lowerBound is element just less than target
        int floor(int[] arr, int x){
            int s=0;
            int e=arr.length-1;
            int index = -1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] <= x){
                    s=mid+1;
                    index=arr[mid];
                }else e=mid-1;
            }
            return index;
        }
        // Element grater than or equal to target
        // Note : whereas upperBound is element just greater than target
        int ceil(int[] arr, int x){
            int s=0;
            int e=arr.length-1;
            int index = -1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] >= x){
                    e=mid-1;
                    index=arr[mid];
                }else s=mid+1;
            }
            return index;
        }

        // Return the first index where the value is greater than target.
        int upperBound(int[] arr, int target){
            int s=0;
            int e=arr.length-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] <= target) s=mid+1;
                else {
                    e=mid-1;
                }
            }
            return s;
        }
        // Return the first index where the value is equal to or greater than target.
        int lowerBound(int[] arr, int target){
            int s=0;
            int e=arr.length-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] < target) s=mid+1;
                else e=mid-1;
            }
            return s;
        }
    }

}
