package com.binarysearch;

//Number of occurrence
//https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-occurrence
public class NumberOfOccurrence {
    class Solution {
        int countFreq(int[] arr, int target) {
            // code here
            int startIndex = findStart(arr, target);
            int endIndex = findEnd(arr, target);
            return startIndex == -1 ? 0 : endIndex-startIndex+1;
        }

        int findStart(int[] arr, int target){
            int s=0;
            int e=arr.length-1;
            int index=-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] == target){
                    index=mid;
                    e=mid-1;
                }
                else if(arr[mid] < target) s=mid+1;
                else e=mid-1;
            }
            return index;
        }
        int findEnd(int[] arr, int target){
            int s=0;
            int e=arr.length-1;
            int index=-1;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] == target){
                    index=mid;
                    s=mid+1;
                }
                else if(arr[mid] < target) s=mid+1;
                else e=mid-1;
            }
            return index;
        }
    }

}
