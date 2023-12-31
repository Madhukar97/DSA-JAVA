package com.problems;

//1306. Jump Game III
//https://leetcode.com/problems/jump-game-iii/description/
public class JumpGameIII {
    //Optimal sol using DP
    class Solution {
        public boolean canReach(int[] arr, int start) {
            int[] vis = new int[arr.length];
            return rec(arr, start, vis);
        }

        public boolean rec(int[] arr, int i, int[] vis){
            if(i<0 || i>=arr.length || vis[i] == 1) return false;
            if(arr[i] == 0) return true;
            vis[i] = 1;
            return rec(arr, i+arr[i], vis) || rec(arr, i-arr[i], vis);
        }
    }
}
