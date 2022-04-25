package com.dynamicprogramming;

import java.util.HashMap;

//1512. Number of Good Pairs
//https://leetcode.com/problems/number-of-good-pairs/
public class NumberOfGoodPairs {
    public static void main(String[] args) {

    }
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;
        int temp = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.replace(nums[i],map.get(nums[i]) + 1);
            }else map.put(nums[i], 1);
        }

        for(Integer key : map.keySet()) {
            ans += map.get(key)*(map.get(key)-1)/2;
        }
        return ans;
    }
}
