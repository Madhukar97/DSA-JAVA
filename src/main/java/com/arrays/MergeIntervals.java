package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//56. Merge Intervals
//https://leetcode.com/problems/merge-intervals/description/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1 ) return intervals;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);

        int[] curr = new int[2];
        curr[0] = intervals[0][0];
        curr[1] = intervals[0][1];
        int flag = 0;

        for(int i=1;i<intervals.length;i++){
            // System.out.print("curr :: " + Arrays.toString(curr));
            // System.out.println(",  interval :: " + Arrays.toString(intervals[i]));
            if(curr[0] < intervals[i][0] && curr[1] < intervals[i][0]){
                List<Integer> iList = new ArrayList<>();
                if(flag==0) {
                    iList.add(curr[0]);
                    iList.add(curr[1]);
                    ans.add(iList);
                }else{
                    flag=0;
                }
                curr[0] = intervals[i][0];
                curr[1] = intervals[i][1];
                if(i==intervals.length-1){
                    List<Integer> iList1 = new ArrayList<>();
                    iList1.add(intervals[i][0]);
                    iList1.add(intervals[i][1]);
                    ans.add(iList1);
                }
            }else {
                if(flag ==1 ){
                    ans.remove(ans.size()-1);
                }
                List<Integer> iList = new ArrayList<>();
                iList.add(Math.min(curr[0], intervals[i][0]));
                iList.add(Math.max(curr[1], intervals[i][1]));
                ans.add(iList);
                curr[0] = iList.get(0);
                curr[1] = iList.get(1);
                flag=1;
            }
        }
        // System.out.println("Array List :: " + ans.toString());

        int[][] list = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            list[i][0] = ans.get(i).get(0);
            list[i][1] = ans.get(i).get(1);
        }
        return list;
    }
}
