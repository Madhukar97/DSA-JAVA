package com.intervals;

import java.util.*;

public class CarPooling {
    public static void main(String[] args) {

    }
    int count=0;
    public boolean carPooling(int[][] trips, int capacity) {
        int max=0;
        ArrayList<TripInfo> list = new ArrayList<>();
        ArrayList<Integer> froms = new ArrayList<>();

        for(int[] trip : trips) {
            list.add(new TripInfo(trip[0], trip[1], trip[2]));
            froms.add(trip[1]);
        }

        for(int i : froms) {
            count = 0;
            list.stream().filter(t -> t.from<=i && t.to>i).forEach(t ->                         {
                count+=t.pass;
                //System.out.println("Pass: " + t.pass);
            });
            //System.out.println(count);
            if(count > capacity) return false;
        }

        return true;
    }
    class TripInfo{
        int pass;
        int from;
        int to;
        TripInfo(int pass, int from, int to){
            this.pass = pass;
            this.from = from;
            this.to = to;
        }
    }

    //Most optimal sol using TreeMap
    class Solution2 {
        public boolean carPooling(int[][] trips, int capacity) {
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for(int[] trip : trips){
                int start = trip[1];
                int end = trip[2];
                int pass = trip[0];
                map.put(start, map.getOrDefault(start, 0)+pass);
                map.put(end, map.getOrDefault(end, 0)-pass);
            }

            int passengers=0;
            for(int val : map.values()){
                passengers+=val;
                if(passengers > capacity) return false;
            }
            return true;
        }
    }
}
