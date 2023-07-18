package com.codestudio.dynamicprogramming.subsetssubsequences;

//Minimum Elements
//https://www.codingninjas.com/studio/problems/minimum-elements_3843091?leftPanelTab=0
public class MinimumElements {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE+2);
    }

    public static int minimumElements(int num[], int x) {
        int ans = rec(num.length-1, x, num);
        if (ans > x) return -1;
        return ans;
    }

    //Normal recursion solution with TC = O(2^n) and SC = O(n) :: giving TLE error
    public static int rec(int ind, int target, int[] nums){
        if(ind == 0){
            if(target % nums[0] == 0) return target/nums[0];
            else return 100000;
        }

        int notPick = 0+rec(ind-1, target, nums);
        int pick = Integer.MAX_VALUE;
        if(target >= nums[ind]) pick = 1+rec(ind, target-nums[ind], nums);

        return Math.min(notPick,pick);
    }

    public static int minimumElementsMem(int num[], int x) {
        int[][] dp = new int[num.length][x+1];
        for(int i=0;i<num.length;i++){
            for(int j=0;j<x+1;j++){
                dp[i][j] = -1;
            }
        }

        int ans = recMem(num.length-1, x, num, dp);
        if (ans > x) return -1;
        return ans;
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*target) , SC = O(n) + dp[n][target+1]
    public static int recMem(int ind, int target, int[] nums, int[][] dp){
        if(ind == 0){
            if(target % nums[0] == 0) return target/nums[0];
            else return 100000;
        }

        if(dp[ind][target] != -1) return dp[ind][target];

        int notPick = 0+recMem(ind-1, target, nums, dp);
        int pick = Integer.MAX_VALUE;
        if(target >= nums[ind]) pick = 1+recMem(ind, target-nums[ind], nums, dp);

        dp[ind][target] = Math.min(notPick,pick);
        return Math.min(notPick,pick);
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*x) , SC = dp[n][x+1]
    public static int minimumElementsTabulation(int num[], int x) {
        int[][] dp = new int[num.length][x+1];
        for(int t=1;t<x+1;t++){
            if( t%num[0]==0 ) dp[0][t] = t/num[0];
            else dp[0][t] = 100000;
        }

        for(int ind=1;ind<num.length;ind++){
            for(int target=0;target<x+1;target++){
                int notPick = dp[ind-1][target];
                int pick = Integer.MAX_VALUE;
                if(target >= num[ind]) pick = 1+dp[ind][target-num[ind]];
                dp[ind][target] =  Math.min(notPick,pick);
            }
        }

        int ans = dp[num.length-1][x];
        if (ans > x) return -1;
        return ans;
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*x) , SC = 2*dp[x+1]
    public static int minimumElementsTabWithSpaceOptimization(int num[], int x) {
        int[] prev = new int[x+1];
        int[] curr = new int[x+1];


        for(int t=1;t<x+1;t++){
            if( t%num[0]==0 ) prev[t] = t/num[0];
            else prev[t] = 100000;
        }

        for(int ind=1;ind<num.length;ind++){
            for(int target=0;target<x+1;target++){
                int notPick = 0+prev[target];
                int pick = Integer.MAX_VALUE;
                if(target >= num[ind]) pick = 1+prev[target-num[ind]];
                curr[target] =  Math.min(notPick,pick);
            }
            prev=curr;
            // curr = new int[x+1];
        }

        int ans = prev[x];
        if (ans > x) return -1;
        return ans;
    }


}
