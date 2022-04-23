package com.problems;

//55. Jump Game
//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    //Sliding window method
    public static boolean canJump(int[] nums) {
        int left = 0;
        int right = 0;
        for ( int i =0; i < nums.length; i++){
            if(i > right) return false;
            if(right > i+nums[i]) left = right+1;
            right = Math.max(right, i+nums[i]);
        }
        return true;
    }
}

