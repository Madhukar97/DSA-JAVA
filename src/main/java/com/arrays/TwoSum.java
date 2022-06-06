package com.arrays;

import java.util.HashMap;

//1. Two Sum
//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {

    }

    // solution with O(n) time and O(n) space
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }
            else map.put(target-nums[i], i);
        }
        return ans;
    }
}
