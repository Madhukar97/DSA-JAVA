package com.binarysearch;

import java.util.ArrayList;

// Allocate Books
//https://www.codingninjas.com/studio/problems/allocate-books_1090540?utm_source=youtube&utm_medium=affiliate&utm_campaign=codestudio_Striver_BinarySeries&leftPanelTabValue=PROBLEM
public class AllocateBooks {
    public class Solution {
        public static int findPages(ArrayList<Integer> arr, int n, int m) {
            if(m>n) return -1;
            int low = Integer.MIN_VALUE;
            int high = 0;
            for(int pgs : arr){
                low= Math.max(low, pgs);
                high+=pgs;
            }

            int minPgs=Integer.MAX_VALUE;
            while(low <= high){
                int mid = low+(high-low)/2;

                int student=1;
                int pages=0;
                for(int pgs : arr){
                    if(pages + pgs <= mid ){
                        pages+=pgs;
                    }else{
                        pages=pgs;
                        student++;
                    }
                }
                // System.out.println("STDS : " + student +", pgs : " + mid);
                if(student == m) minPgs = Math.min(minPgs, mid);
                if(student <= m) high=mid-1;
                else low=mid+1;
            }
            return low;
        }
    }
}
