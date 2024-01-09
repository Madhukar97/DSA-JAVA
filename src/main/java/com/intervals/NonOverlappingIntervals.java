package com.intervals;

import java.util.Arrays;

//435. Non-overlapping Intervals
//https://leetcode.com/problems/non-overlapping-intervals/description/
public class NonOverlappingIntervals {
    //sort intervals based on end time and count valid intervals
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a1, a2)-> a1[1]-a2[1]);
            int count=1;
            int prev=0;
            for(int i=0;i<intervals.length;i++){
                if(intervals[prev][1] <= intervals[i][0]){
                    count++;
                    prev=i;
                }
            }
            return intervals.length - count;
        }
    }
}
