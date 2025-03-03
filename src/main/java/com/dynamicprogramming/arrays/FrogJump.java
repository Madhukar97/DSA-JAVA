package com.dynamicprogramming.arrays;

//https://www.geeksforgeeks.org/problems/geek-jump/1?utm_source=youtube
public class FrogJump {

    // Brute Force sol giving TLE error using recursion TC=O(n!) and SC=O(n) stack space
    class Solution1 {
        int minCost(int[] height) {
            int[] min = {Integer.MAX_VALUE};
            recursion(height.length-1, height, min, 0, height[height.length-1]);
            return min[0];
        }

        void recursion(int step, int[] height, int[] min, int cost, int prevHt){
            if(step == 0) {
                cost += Math.abs(height[0] - prevHt);
                if(cost < min[0]) min[0] = cost;
                return;
            }
            if(step < 0 ) return;

            cost += Math.abs(height[step] - prevHt);

            recursion(step-1, height, min, cost, height[step]);
            recursion(step-2, height, min, cost, height[step]);
        }
    }

    //Brute force sol 2
    class Solution11 {
        int minCost(int[] height) {
            int n = height.length;
            return rec(n-1, height);
        }
        int rec(int stair, int[] height){
            if(stair == 0) return 0;
            if(stair < 0) return Integer.MAX_VALUE;

            int jump1 = rec(stair-1, height) + Math.abs(height[stair] - height[stair-1]);
            int jump2 = Integer.MAX_VALUE;
            if(stair-2 >= 0) jump2 = rec(stair-2, height) + Math.abs(height[stair] - height[stair-2]);
            return Math.min(jump1, jump2);
        }
    }

    // Better sol using Memoization sol giving TLE, TC=O(n) and SC=O(n) + O(n) : stack space and array length
    class Solution2 {
        int minCost(int[] height) {
            int n = height.length;
            int[] mem = new int[n];
            for(int i=0;i<n;i++) mem[i] = -1;

            return recursion(n-1, height, mem);
        }

        int recursion(int step, int[] height, int[] mem){
            if(step == 0) {
                return 0;
            }
            if(step < 0 ) return Integer.MAX_VALUE;

            if(mem[step] != -1 ) return mem[step];

            int jump1 = recursion(step-1, height, mem) + Math.abs(height[step] - height[step-1]);
            int jump2 = Integer.MAX_VALUE;

            if(step-2 >= 0) jump2 = recursion(step-2, height, mem) + Math.abs(height[step] - height[step-2]);

            return Math.min( jump1, jump2);
        }
    }

    // Optimal sol using Tabulation TC=O(n) and SC=O(n) : array length
    class Solution3 {
        int minCost(int[] height) {
            int n = height.length;
            int[] mem = new int[n];
            for(int i=0;i<n;i++) mem[i] = -1;

            mem[0] = 0;
            for(int step=1;step<n;step++){
                int jump1 = mem[step-1] + Math.abs(height[step] - height[step-1]);
                int jump2 = Integer.MAX_VALUE;

                if(step-2 >= 0) jump2 = mem[step-2] + Math.abs(height[step] - height[step-2]);

                mem[step] = Math.min( jump1, jump2);
            }
            return mem[n-1];
        }
    }

    // Most optimal sol using space optimization TC=O(n) and SC=O(1) : 2 variables
    class Solution4 {
        int minCost(int[] height) {
            int n = height.length;
            int curr = 0;
            int prev1 = 0;
            int prev2 = 0;

            for(int step=1;step<n;step++){
                int jump1 = prev1 + Math.abs(height[step] - height[step-1]);
                int jump2 = Integer.MAX_VALUE;

                if(step-2 >= 0) jump2 = prev2 + Math.abs(height[step] - height[step-2]);

                curr = Math.min( jump1, jump2);
                prev2 = prev1;
                prev1 = curr;
            }
            return curr;
        }
    }
}
