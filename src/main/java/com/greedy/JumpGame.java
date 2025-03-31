package com.greedy;

import java.util.Arrays;

//55. Jump Game
//https://leetcode.com/problems/jump-game/description/
public class JumpGame {
    // Greedy sol : most optimal , TC = O(n) , SC = O(1)
    class Solution {
        public boolean canJump(int[] nums) {
            int max=0;
            for(int i=0;i<nums.length-1 && i <= max;i++){
                max = Math.max(max, i + nums[i]);
            }
            return max >= nums.length-1;
        }
    }

    // Better sol using Recursion and Memoization TC = O(n*n) SC = O(n)
    // For only recursion TC = O(n^n) and SC = O(1)
    class Solution2 {
        public boolean canJump(int[] nums) {
            int[] validJumps = new int[nums.length];
            Arrays.fill(validJumps, -1);
            return rec(nums, 0, validJumps);
        }
        public boolean rec(int[] nums, int index, int[] validJumps){
            if(index >= nums.length ) return false;
            if(index == nums.length-1) return true;
            if(nums[index]==0) return false;
            if(validJumps[index] != -1) return validJumps[index]==1;

            boolean isPossible = false;
            for(int i=1;i<=nums[index];i++) isPossible = isPossible || rec(nums, index+i, validJumps);
            return (validJumps[index] = isPossible ? 1 : 0) == 1;
        }
    }
}
