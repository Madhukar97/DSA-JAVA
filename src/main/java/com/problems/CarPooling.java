package com.problems;

import java.util.ArrayList;

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
}
