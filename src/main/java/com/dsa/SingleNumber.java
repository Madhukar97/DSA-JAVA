package com.dsa;

//136. Single Number
//https://leetcode.com/problems/single-number/
public class SingleNumber {
    public static void main(String[] args) {

    }
    // using xor operator O(n) time and O(1) space complexity
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

}
