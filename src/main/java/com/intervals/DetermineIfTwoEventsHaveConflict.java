package com.intervals;

//2446. Determine if Two Events Have Conflict
//https://leetcode.com/problems/determine-if-two-events-have-conflict/description/
public class DetermineIfTwoEventsHaveConflict {
    //Events start and end are given in HH:MM format, so convert it to mins and compare
    class Solution {
        public boolean haveConflict(String[] event1, String[] event2) {
            int s1 = Integer.parseInt(event1[0].substring(0,2))*60 + Integer.parseInt(event1[0].substring(3,5));
            int e1 = Integer.parseInt(event1[1].substring(0,2))*60 + Integer.parseInt(event1[1].substring(3,5));
            int s2 = Integer.parseInt(event2[0].substring(0,2))*60 + Integer.parseInt(event2[0].substring(3,5));
            int e2 = Integer.parseInt(event2[1].substring(0,2))*60 + Integer.parseInt(event2[1].substring(3,5));
            return Math.max(s1,s2) <= Math.min(e1,e2);
        }
    }
}
