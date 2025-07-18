package com.intervals;

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

    public int[][] mergeSol2(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        for(int i=0;i<n;i++){
            if(ansList.size()==0 || ansList.get(ansList.size()-1).get(1) < intervals[i][0]){
                List<Integer> list = new ArrayList<>();
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                ansList.add(list);
            }else{
                ansList.get(ansList.size()-1).set(1, Math.max(intervals[i][1], ansList.get(ansList.size()-1).get(1)));
            }
        }

        int[][] ans = new int[ansList.size()][2];
        int i=0;
        for(List<Integer> list: ansList){
            int[] interval = {list.get(0),list.get(1)};
            ans[i] = interval;
            i++;
        }
        return ans;
    }

    //Revision 2
    public int[][] mergeR2(int[][] intervals) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(intervals, (a1,a2)->a1[0]-a2[0]);

        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        ansList.add(list);
        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            List<Integer> prev = ansList.get(ansList.size()-1);
            if(prev.get(1) >= interval[0]){
                prev.set(1, Math.max(interval[1], prev.get(1)));
            }else{
                List<Integer> newInterval = new ArrayList<>();
                newInterval.add(interval[0]);
                newInterval.add(interval[1]);
                ansList.add(newInterval);
            }
        }

        int[][] ans = new int[ansList.size()][2];
        for(int i=0;i<ansList.size();i++){
            List<Integer> interval = ansList.get(i);
            ans[i][0] = interval.get(0);
            ans[i][1] = interval.get(1);
        }
        return ans;
    }

    //Revision 3
    public int[][] merge3(int[][] intervals) {
        Arrays.sort(intervals, (a1,a2) -> a1[0]-a2[0]);

        List<List<Integer>> list = new ArrayList<>();
        for(int[] interval : intervals){
            if(list.size()==0 || list.get(list.size()-1).get(1) < interval[0]){
                List<Integer> l1 = new ArrayList<>();
                l1.add(interval[0]);
                l1.add(interval[1]);
                list.add(l1);
            }else{
                List<Integer> prev = list.get(list.size()-1);
                prev.set(0, Math.min(prev.get(0), interval[0]));
                prev.set(1, Math.max(prev.get(1), interval[1]));
            }
        }
        int[][] ans = new int[list.size()][2];
        for(int i=0;i<list.size();i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}
