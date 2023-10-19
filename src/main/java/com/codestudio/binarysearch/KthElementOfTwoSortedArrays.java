package com.codestudio.binarysearch;

//Kth Element of Two Sorted Arrays
//https://www.codingninjas.com/studio/problems/1112629?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class KthElementOfTwoSortedArrays {
    //Most optimal binary search sol with time O(log(min(n,m)) and Space O(1)
    public static int ninjaAndLadoos(int arr1[], int arr2[], int n, int m, int k) {
        if(n > m) return ninjaAndLadoos(arr2,arr1,m,n,k);
        int s=Math.max(0,k-m);
        int e=Math.min(n,k);
        int total=n+m;

        while(s<=e){
            int mid1=(s+e)/2;
            int mid2=k-mid1;
            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;
            if(mid1-1 >=0) l1=arr1[mid1-1];
            if(mid2-1 >=0) l2=arr2[mid2-1];
            if(mid1>=0 && mid1 < n) r1=arr1[mid1];
            if(mid2>=0 && mid2 < m) r2=arr2[mid2];
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }else if( l1 > r2) e = mid1-1;
            else s=mid1+1;
        }
        return 0;
    }
}
