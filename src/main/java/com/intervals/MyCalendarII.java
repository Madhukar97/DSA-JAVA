package com.intervals;

import java.util.ArrayList;

//731. My Calendar II
//https://leetcode.com/problems/my-calendar-ii/description/
public class MyCalendarII {
    class MyCalendarTwo {
        ArrayList<Booking> bookings;
        ArrayList<Booking> doubleBookings;

        public MyCalendarTwo() {
            bookings = new ArrayList<>();
            doubleBookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            //1st check for double bookings
            for(Booking booking : doubleBookings){
                if(isOverlap(booking.start,booking.end,start,end)) return false;
            }
            //next check for overlaps and add overlaps to doubleBookings
            for(Booking booking : bookings){
                if(isOverlap(booking.start, booking.end,start,end)){
                    doubleBookings.add(new Booking(Math.max(booking.start,start), Math.min(booking.end,end)));
                }
            }
            bookings.add(new Booking(start,end));
            return true;
        }

        public boolean isOverlap(int s1, int e1, int s2, int e2){
            return Math.max(s1,s2) < Math.min(e1,e2);
        }

        class Booking{
            int start;
            int end;

            Booking(int start, int end){
                this.start=start;
                this.end=end;
            }
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
