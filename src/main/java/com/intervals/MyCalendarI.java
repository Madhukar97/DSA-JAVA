package com.intervals;

import java.util.TreeMap;

//729. My Calendar I
//https://leetcode.com/problems/my-calendar-i/description/
public class MyCalendarI {
    class MyCalendar {
        TreeMap<Integer,Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer prevKey = map.floorKey(start);
            Integer nextKey = map.ceilingKey(start);
            if(prevKey != null && nextKey != null){
                if(map.get(prevKey) <= start && end <= nextKey) {
                    map.put(start,end);
                    return true;
                }else return false;
            }
            else if(prevKey != null && nextKey == null) {
                if (map.get(prevKey) <= start) {
                    map.put(start,end);
                    return true;
                }else return false;

            }
            else if(prevKey == null && nextKey != null){
                if (end <= nextKey) {
                    map.put(start,end);
                    return true;
                }else return false;
            }else{
                map.put(start,end);
                return true;
            }
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
