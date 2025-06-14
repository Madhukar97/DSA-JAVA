package com.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//N meetings in one room
//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
//https://www.codingninjas.com/studio/problems/maximum-meetings_1062658?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class NMeetingsInOneRoom {
    static class Meeting{
        int start;
        int end;
        int pos;

        Meeting(int start, int end, int pos){
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
    public static int maximumMeetings(int []start, int []end) {
        int n=start.length;
        List<Meeting> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new Meeting(start[i],end[i],i));
        }

        list.sort((m1,m2)->m1.end-m2.end);

        int ans=0;
        int prev=-1;
        for(Meeting m : list){
            if(m.start > prev){
                ans++;
                prev=m.end;
            }
        }
        return ans;
    }

    // Revision 5
    class Solution {
        // Function to find the maximum number of meetings that can
        // be performed in a meeting room.
        public int maxMeetings(int start[], int end[]) {
            // add your code here
            List<Meeting> list = new ArrayList<>();
            for(int i=0;i<end.length;i++) list.add(new Meeting(start[i], end[i]));
            Collections.sort(list, (m1, m2) -> m1.end-m2.end);
            int count = 0;
            int prevEnd=-1;
            for(Meeting meeting : list){
                if(meeting.start > prevEnd){
                    count++;
                    prevEnd = meeting.end;
                }
            }
            return count;
        }

        class Meeting {
            int start;
            int end;

            public Meeting(int s, int e){
                start=s;
                end=e;
            }
        }
    }
}
