package com.arrays;

import java.util.*;

//452. Minimum Number of Arrows to Burst Balloons
//leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
public class MinimumNumberOfArrowsToBurstBalloons {
    //Sol using merge intervals : merge and form the overlapping part only since need to shoot an arrow
    //Write compareTo function for sorting because p1[0](=Integer.MIN_VALUE) - p2[0](=Integer.MAX_VALUE) will go out of range and improperly sorts the start intervals
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (p1, p2)->{
                int first = p1[0];
                int second = p2[0];
                if(first == second) return 0;
                else if(first < second) return -1;
                else return 1;
            });
            List<List<Integer>> ans = new ArrayList<>();
            for(int[] pt : points){
                if(ans.size()==0 || ans.get(ans.size()-1).get(1) < pt[0]){
                    List<Integer> interval = new ArrayList<>();
                    interval.add(pt[0]);
                    interval.add(pt[1]);
                    ans.add(interval);
                }else {
                    List<Integer> prev = ans.get(ans.size()-1);
                    ans.remove(ans.size()-1);
                    int start = Math.max(prev.get(0), pt[0]);
                    int end = Math.min(prev.get(1), pt[1]);
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    ans.add(list);
                }
            }
            return ans.size();
        }
    }
}
