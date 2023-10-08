package com.striver.sde.sheet;

//775. Global and Local Inversions
//https://leetcode.com/problems/global-and-local-inversions/description/
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] nums) {
        int max=Integer.MIN_VALUE;

        for(int i=0;i<nums.length-2;i++){
            max = Math.max(max, nums[i]);
            if(max > nums[i+2]) return false;
        }
        return true;
    }
}
