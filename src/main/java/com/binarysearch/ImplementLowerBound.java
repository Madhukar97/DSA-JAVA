package com.binarysearch;

//Implement Lower Bound
//https://www.naukri.com/code360/problems/lower-bound_8165382?leftPanelTabValue=PROBLEM
public class ImplementLowerBound {
    public class Solution {
        public static int lowerBound(int []arr, int n, int x) {
            int s=0;
            int e=n-1;
            int index=n;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(arr[mid] >= x){
                    e=mid-1;
                    index=mid;
                }else s=mid+1;
            }
            return index;
        }
    }
}
