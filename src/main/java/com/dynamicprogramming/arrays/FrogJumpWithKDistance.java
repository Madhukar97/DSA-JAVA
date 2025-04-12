package com.dynamicprogramming.arrays;

import java.util.*;

//https://leetcode.com/problems/frog-jump/description/
public class FrogJumpWithKDistance {

    // Brute force sol using recursion
    class Solution1 {
        public boolean canCross(int[] stones) {
            int n = stones.length;
            return rec(0, stones, 0);
        }

        public boolean rec(int pos, int[] stones, int lastJump){
            if(pos == stones.length-1) return true;
            if(pos > stones.length-1) return false;

            boolean kminus=false;
            if(lastJump - 1>= 0) {
                for(int i=pos+1;i<stones.length;i++){
                    if(stones[i] - stones[pos] == lastJump-1) {
                        kminus = rec(i, stones, lastJump-1);
                        break;
                    }
                }
            }
            boolean k=false;
            for(int i=pos+1;i<stones.length;i++){
                if(stones[i] - stones[pos] == lastJump) {
                    k = rec(i, stones, lastJump);
                    break;
                }
            }
            boolean kplus=false;
            for(int i=pos+1;i<stones.length;i++){
                if(stones[i] - stones[pos] == lastJump+1) {
                    kplus = rec(i, stones, lastJump+1);
                    break;
                }
            }
            return kminus || k || kplus;
        }
    }

    // Better sol using memoization
    class Solution2 {
        public boolean canCross(int[] stones) {
            int n = stones.length;
            int[][] dp = new int[n][n];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return rec(0, stones, 0, dp);
        }

        public boolean rec(int pos, int[] stones, int lastJump, int[][] dp){
            if(pos == stones.length-1) return true;
            if(pos > stones.length-1) return false;

            if (dp[pos][lastJump] != -1) {
                return dp[pos][lastJump] == 1;
            }

            boolean kminus=false;
            if(lastJump - 1>= 0) {
                for(int i=pos+1;i<stones.length;i++){
                    if(stones[i] - stones[pos] == lastJump-1) {
                        kminus = rec(i, stones, lastJump-1, dp);
                        break;
                    }
                }
            }
            boolean k=false;
            for(int i=pos+1;i<stones.length;i++){
                if(stones[i] - stones[pos] == lastJump) {
                    k = rec(i, stones, lastJump, dp);
                    break;
                }
            }
            boolean kplus=false;
            for(int i=pos+1;i<stones.length;i++){
                if(stones[i] - stones[pos] == lastJump+1) {
                    kplus = rec(i, stones, lastJump+1, dp);
                    break;
                }
            }
            dp[pos][lastJump] = (kminus || k || kplus) ? 1 : 0;
            return dp[pos][lastJump] == 1;
        }
    }

    // Better sol using memoization and hashing
    class Solution22 {
        public boolean canCross(int[] stones) {
            if (stones[1] - stones[0] != 1) {
                return false;
            }
            int n = stones.length;
            int[][] dp = new int[n][n];
            Map<Integer, Integer> hashmap = new HashMap<>();
            for(int i=0;i<n;i++) hashmap.put(stones[i], i);

            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }
            return rec(1, stones, 1, dp, hashmap);
        }

        public boolean rec(int pos, int[] stones, int lastJump, int[][] dp, Map<Integer, Integer> hashmap){
            if(pos == stones.length-1) return true;
            if (dp[pos][lastJump] != -1) {
                return dp[pos][lastJump] == 1;
            }

            boolean kminus=false;
            if(lastJump > 1 && hashmap.containsKey(stones[pos] + lastJump-1)){
                kminus = rec(hashmap.get(stones[pos] + lastJump-1), stones, lastJump-1, dp, hashmap);
            }
            boolean k=false;
            if(hashmap.containsKey(stones[pos] + lastJump)){
                k = rec(hashmap.get(stones[pos] + lastJump), stones, lastJump, dp, hashmap);
            }
            boolean kplus=false;
            if(hashmap.containsKey(stones[pos] + lastJump+1)){
                kplus = rec(hashmap.get(stones[pos] + lastJump+1), stones, lastJump+1, dp, hashmap);
            }
            dp[pos][lastJump] = (kminus || k || kplus) ? 1 : 0;
            return dp[pos][lastJump] == 1;
        }
    }

    // Tabulation sol
    class Solution {
        public boolean canCross(int[] stones) {
            if (stones[1] - stones[0] != 1) return false;
            int n = stones.length;
            int[][] dp = new int[n][n];
            // for(int[] row : dp) Arrays.fill(row, -1);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) map.put(stones[i], i);

            for (int j = 0; j < n; j++) dp[n - 1][j] = 1; // base case

            for (int i = n - 2; i > 0; i--) {
                for (int k = 1; k < n; k++) {
                    boolean k1 = false;
                    boolean k2 = false;
                    boolean k3 = false;

                    if (map.containsKey(stones[i] + k - 1)) {
                        k1 = dp[map.get(stones[i] + k - 1)][k - 1] == 1;
                    }
                    if (map.containsKey(stones[i] + k)) {
                        k2 = dp[map.get(stones[i] + k)][k] == 1;
                    }
                    if (k + 1 < n && map.containsKey(stones[i] + k + 1)) {
                        k3 = dp[map.get(stones[i] + k + 1)][k + 1] == 1;
                    }
                    dp[i][k] = k1 || k2 || k3 ? 1 : 0;
                }
            }
            return dp[1][1] == 1;
        }
    }
}
