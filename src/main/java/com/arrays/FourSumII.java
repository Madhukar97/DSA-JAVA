package com.arrays;

import java.util.HashMap;
import java.util.Map;

//454. 4Sum II
//https://leetcode.com/problems/4sum-ii/description/
public class FourSumII {
    //Brute force Time Complexity :- BigO(N^4)
    //TLE
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                for(int k : nums3)
                    for(int l : nums4)
                        if(i + j + k + l == 0) count++;
        return count;
    }

    //Better sol using hashing Time Complexity :- BigO(N^3)
    //TLE
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int l : nums4)
            map.put(l, map.getOrDefault(l, 0) + 1); // if number already present the inrement with + 1, otherwise add in map
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                for(int k : nums3)
                    count += map.getOrDefault(-(i + j + k), 0); // we have to find out the -ve of i + j + k
        // & in d we have to find such no that -(i + j + k) + l gives = 0. If it is there get it otherwise get 0
        // and update the count
        return count;
    }

    //Optimal Time Complexity :- BigO(N^2) , Space Complexity :- BigO(N^2)
    public int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums3)
            for(int l : nums4)
                map.put(k + l, map.getOrDefault(k + l, 0) + 1);
        int count = 0;
        for(int i : nums1)
            for(int j : nums2)
                count += map.getOrDefault(-(i + j), 0);
        return count;
    }
}
