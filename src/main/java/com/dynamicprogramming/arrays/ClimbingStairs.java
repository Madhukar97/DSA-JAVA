package com.dynamicprogramming.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/climbing-stairs/description/
public class ClimbingStairs {

    // Brute force sol giving TLE error using recursion TC=O(n!) and SC=O(n) stack space
    class Solution1 {
        public int climbStairs(int n) {
            return recursion(0, n);
        }

        public int recursion(int step, int n){
            if(step == n) return 1;
            if(step > n) return 0;

            return recursion(step+1, n) + recursion(step+2, n);
        }
    }

    // Better sol using memoization TC=O(n) and SC=O(n) + O(n) : stack space and array length
    // Always solve from n to 1 in recursion
    class Solution2 {
        public int climbStairs(int n) {
            int[] mem = new int[n+1];
            Arrays.fill(mem, -1);
            recursion(n, mem);
            return mem[n];
        }

        public int recursion( int step, int[] mem){
            if(step == 0) return 1;
            if(step < 0) return 0;

            if(mem[step] != -1) return mem[step];

            mem[step] = recursion(step-1, mem) + recursion(step-2, mem);
            return mem[step];
        }
    }

    // Optimal sol using tabulation TC=O(n) and SC=O(n) : array length
    class Solution3 {
        public int climbStairs(int n) {
            int[] mem = new int[n+1];
            Arrays.fill(mem, -1);
            mem[0] = 1;

            for(int step=0;step<n+1;step++){
                if(step-1 >= 0) mem[step] = mem[step-1];
                if(step-2 >= 0) mem[step] += mem[step-2];
            }
            return mem[n];
        }
    }

    // Most Optimal sol using space optimization TC=O(n) and SC=O(1) : 2 variables
    class Solution4 {
        public int climbStairs(int n) {
            int curr = 1;
            int prev1 = 0;
            int prev2 = 0;

            for(int step=0;step<n+1;step++){
                if(step-1 >= 0) curr = prev1;
                if(step-2 >= 0) curr += prev2;

                prev2 = prev1;
                prev1 = curr;
            }
            return curr;
        }
    }
}
