package com.arrays;

import java.util.ArrayList;
import java.util.List;

//57. Insert Interval
//https://leetcode.com/problems/insert-interval/description/
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> ans = new ArrayList<>();

        if(intervals.length==0){
            int[][] list = new int[1][2];
            list[0][0] = newInterval[0];
            list[0][1] = newInterval[1];
            return list;
        }
        int flag=0;

        for(int i=0;i<intervals.length;i++){
            // System.out.print("curr :: " + Arrays.toString(intervals[i]));
            // System.out.print(",  interval :: " + Arrays.toString(newInterval));
            if(intervals[i][0] < newInterval[0] && intervals[i][1] < newInterval[0] ||
                    intervals[i][0] > newInterval[1] ){
                if(intervals[i][0] > newInterval[1] && flag == 0){
                    List<Integer> iList2 = new ArrayList<>();
                    iList2.add(newInterval[0]);
                    iList2.add(newInterval[1]);
                    ans.add(iList2);
                    flag=1;
                }
                List<Integer> iList = new ArrayList<>();
                iList.add(intervals[i][0]);
                iList.add(intervals[i][1]);
                ans.add(iList);
                if(i == intervals.length-1 && flag == 0  ){
                    List<Integer> iList2 = new ArrayList<>();
                    iList2.add(newInterval[0]);
                    iList2.add(newInterval[1]);
                    ans.add(iList2);
                }
            }else {
                List<Integer> iList = new ArrayList<>();
                if(flag==1){
                    iList.add(Math.min(ans.get(ans.size()-1).get(0),Math.min(intervals[i][0], newInterval[0])));
                    iList.add(Math.max(ans.get(ans.size()-1).get(1),Math.max(intervals[i][1], newInterval[1])));
                    ans.remove(ans.size()-1);
                    ans.add(iList);
                }
                else {
                    iList.add(Math.min(intervals[i][0], newInterval[0]));
                    iList.add(Math.max(intervals[i][1], newInterval[1]));
                    ans.add(iList);
                }
                flag=1;
                // System.out.println(",  merged :: " + iList.toString());
            }
            // System.out.println(",  ans :: " + ans.toString());
        }

        int[][] list = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            list[i][0] = ans.get(i).get(0);
            list[i][1] = ans.get(i).get(1);
        }
        // Arrays.sort(list, (arr1, arr2) -> arr1[0] - arr2[0]);
        return list;
    }
}
