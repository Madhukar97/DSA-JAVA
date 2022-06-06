package com.arrays;

import java.util.Map;
import java.util.TreeMap;

//1854. Maximum Population Year
//https://leetcode.com/problems/maximum-population-year/
public class MaximumPopulationYear {
    public static void main(String[] args) {
    }

    // method of worst time complexity O(n^2) ans O(1) space complexity
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i=0; i<logs.length; i++) {
            for(int j = logs[i][0] ; j< logs[i][1]; j++) {
                if(map.containsKey(j)) map.put(j, map.get(j) +1);
                else map.put(j, 1);
            }
        }

        int val = 1;
        int ans = 1950;
        if(map.containsKey(1950)) ans = 1950;
        else ans = logs[0][0];
        for(int key : map.keySet()) {
            if(map.get(key) > val){
                ans = key;
                val = map.get(key);
            }
        }
        //System.out.println(val);
        return ans;
    }

    // solution with best time complexity O(n) ans O(1) space ccmplexity
    public int maximumPopulation2(int[][] logs) {
        int[] years = new int[101];

        for(int[] log : logs) {
            int yr = log[0]-1950;
            years[yr]+=1;
            yr = log[1]-1950;
            years[yr]-=1;
        }

        int max = 0;
        int count = 0;
        int yr = 1950;
        for(int i=0; i<years.length ; i++) {
            count+=years[i];
            if(count > max) {
                max = count;
                yr=i ;
            }
        }
        return 1950+yr;
    }
}
