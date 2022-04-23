package com.problems;

//45. Jump Game II
//https://leetcode.com/problems/jump-game-ii/
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;
        for( int i=0; i < nums.length; i++) {
            if(right >= nums.length) return jumps;
            //if(right > nums[i] + 1) left = right+1;
            right = Math.max(right, nums[i] +i);
            jumps++;
            i=right;
        }
        return jumps;
    }
}
