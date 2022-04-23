package com.problems;

//45. Jump Game II
//https://leetcode.com/problems/jump-game-ii/
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        if(nums.length == 1 ) return 0;
        int jumps = 0;
        int left = 0;
        int right = 0;
        int farthest = 0;
        while(right < nums.length-1) {
            for(int i = left; i <= right; i++) {
                farthest = Math.max(farthest, nums[i] + i);
            }
            left = right+1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}
