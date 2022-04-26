package com.dynamicprogramming;

import java.util.HashMap;

//2001. Number of Pairs of Interchangeable Rectangles
//https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/
public class NumberofPairsofInterchangeableRectangles {
    public static void main(String[] args) {
        int[][] rect = {{4,8},{3,6},{10,20},{15,30}};
        int[][] rect2 = {{4,8},{3,6},{15,30},{1,3},{2,6}};
        System.out.println(interchangeableRectangles(rect));
        System.out.println(interchangeableRectangles(rect2));
    }
    //dynamic programming O(log(n)) time complexity and O(n) space complexity
    public static long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Long> map = new HashMap<>();
        long ans=0;
        long val = 0l;
        for(int i=0; i<rectangles.length; i++) {
            double ratio = (double)rectangles[i][0]/(double)rectangles[i][1];
            if(map.containsKey(ratio)) {
                val = map.get(ratio)+1;
                map.put(ratio, val);
                ans+=val;
            }else map.put(ratio, 0l);
        }
        return ans;
    }
}
