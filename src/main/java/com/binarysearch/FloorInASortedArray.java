package com.binarysearch;

//Floor in a Sorted Array
//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array
public class FloorInASortedArray {
    class Solution {

        static int findFloor(int[] arr, int x) {
            // write code here
            int s=0;
            int e=arr.length-1;
            int index=-1;

            while(s <= e){
                int mid = s+(e-s)/2;
                if(arr[mid] <= x) {
                    s=mid+1;
                    index=mid;
                }
                else e=mid-1;
            }
            return index;
        }
    }
}
