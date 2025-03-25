package com.binarysearch;

// Implement Upper Bound
// https://www.naukri.com/code360/problems/implement-upper-bound_8165383?leftPanelTabValue=PROBLEM
public class ImplementUpperBound {
    public class Solution {
        public static int upperBound(int []arr, int x, int n){
            int s=0;
            int e=n-1;
            int index=n;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] > x){
                    e=mid-1;
                    index=mid;
                }else s=mid+1;
            }
            return index;
        }
    }
}
