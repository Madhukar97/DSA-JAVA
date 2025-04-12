package com.binarysearch;

import java.util.ArrayList;

// Painter's Partition Problem
//https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
public class PaintersPartitionProblem {
    //Similar to Allocate books
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int b : boards){
            low=Math.max(low,b);
            high+=b;
        }

        int minTime=Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;

            int painters=1;
            int len=0;
            for(int b : boards){
                if(len+b <= mid){
                    len+=b;
                }else{
                    len=b;
                    painters++;
                }
            }
            if(painters == k) minTime = Math.min(minTime, mid);
            if(painters <= k) high=mid-1;
            else low = mid+1;
        }
        return low;
    }
}
