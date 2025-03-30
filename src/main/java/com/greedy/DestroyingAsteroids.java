package com.greedy;

import java.util.Arrays;

//2126. Destroying Asteroids
//https://leetcode.com/problems/destroying-asteroids/description/
public class DestroyingAsteroids {
    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long wt = (long)mass;
            for(int a : asteroids){
                if(wt >= a) wt+=a;
                else return false;
            }
            return true;
        }
    }
}
