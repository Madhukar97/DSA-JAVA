package com.arrays;

//436. Find Right Interval
//https://leetcode.com/problems/find-right-interval/
public class FindRightInterval {
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int[] ans = new int[intervals.length];
            int i=0;
            for(int[] interval : intervals){
                int min=Integer.MAX_VALUE;
                int index=-1;
                int j=0;
                for(int[] right : intervals){
                    if(right[0] >= interval[1]){
                        if(right[0] < min){
                            min = right[0];
                            index=j;
                        }
                    }
                    j++;
                }
                ans[i++] = index;
            }
            return ans;
        }
    }
}
