package com.slidingwindowtwopointer;

import java.util.*;

//992. SubArrays with K Different Integers
//https://leetcode.com/problems/subarrays-with-k-different-integers/description/
public class SubArraysWithKDifferentIntegers {
    class Solution {
        public int subarraysWithKDistinct(int[] nums, int k) {
            return countSubArrays(nums,k) - countSubArrays(nums,k-1);
        }
        // Count sub-arrays lesser than equal to k
        public int countSubArrays(int[] nums, int k){
            if(k<0) return 0;
            int l=0,r=0,count=0;
            Map<Integer,Integer> map = new HashMap<>();

            while(r < nums.length){
                map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
                while(map.size() > k){
                    if(map.get(nums[l]) == 1) map.remove(nums[l]);
                    else map.put(nums[l], map.get(nums[l])-1);
                    l++;
                }
                count+=r-l+1;
                r++;
            }
            return count;
        }
    }
}
