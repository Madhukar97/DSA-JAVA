package com.arrays;

//136. Single Number
//https://leetcode.com/problems/single-number/description/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums) ans^=n;
        return ans;
    }
}
