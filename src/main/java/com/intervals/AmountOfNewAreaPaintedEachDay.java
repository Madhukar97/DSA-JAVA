package com.intervals;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//2158. Amount of New Area Painted Each Day
//https://algo.monster/liteproblems/2158
//
public class AmountOfNewAreaPaintedEachDay {
    //Intervals Sol using TreeSet
    public int[] amountPainted(int[][] paint){
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<=100000;i++) set.add(i);

        int[] ans = new int[paint.length];
        for(int i=0;i<paint.length;i++){
            int start = paint[i][0];
            int end = paint[i][1];
            while(true){
                int ciel = set.ceiling(start);
                if(ciel >= end) break;
                set.remove(ciel);
                ans[i]++;
            }
        }
        return ans;
    }
}
