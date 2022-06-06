package com.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

//136. Single Number
//https://leetcode.com/problems/single-number/
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};

        // bit manipulation doesnt work for below input negative integers
        int[] nums2 = {-1, -17, -12, 8, 16, -17, -13, -14, -3, -6, -5, -11, -10, -12, -5, 19, -17, -5, -1, 12};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i< nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
