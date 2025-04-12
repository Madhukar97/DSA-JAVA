package com.intervals;

import java.util.TreeMap;

//732. My Calendar III
//https://leetcode.com/problems/my-calendar-iii/description
public class MyCalendarIII {
    class MyCalendarThree {
        TreeMap<Integer,Integer> map;

        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int startTime, int endTime) {
            map.put(startTime, map.getOrDefault(startTime, 0)+1);
            map.put(endTime, map.getOrDefault(endTime, 0) -1);
            int max=0;
            int count=0;
            for(int key : map.keySet()){
                count+=map.get(key);
                max = Math.max(max, count);
            }
            return max;
        }
    }

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
}
