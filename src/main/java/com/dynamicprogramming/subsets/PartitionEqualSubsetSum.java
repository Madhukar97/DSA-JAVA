package com.dynamicprogramming.subsets;

//https://leetcode.com/problems/partition-equal-subset-sum/description/
//416. Partition Equal Subset Sum
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%2 != 0) return false;
        return rec(nums.length-1 ,nums, sum/2);
    }

    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE in leetcode
    public boolean rec(int index, int[] nums, int target){
        if(index == 0) {
            if(nums[index] == target) return true;
            else return false;
        }
        if(nums[index] == target) return true;

        boolean notTake = rec(index-1, nums, target);
        boolean take = false;
        if(nums[index-1] <= target) take = rec(index-1, nums, target-nums[index]);

        return notTake || take;
    }

    public boolean canPartitionMemoization(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }

        int[][] dp = new int[nums.length][sum/2+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<sum/2+1;j++){
                dp[i][j] = -1;
            }
        }

        if(sum%2 != 0) return false;
        return recMem(nums.length-1 ,nums, sum/2, dp);
    }

    //Recursion with Memoization(Top-Down approach) TC = O(n*target) and SC = O(n) + dp[n][target+1]
    public boolean recMem(int index, int[] nums, int target, int[][] dp){
        if(index == 0) {
            if(nums[index] == target) return true;
            else return false;
        }
        if(nums[index] == target) return true;

        if(dp[index][target] != -1) {
            if(dp[index][target] == 0) return false;
            else return true;
        }

        boolean notTake = recMem(index-1, nums, target, dp);
        boolean take = false;
        if(nums[index] <= target) take = recMem(index-1, nums, target-nums[index], dp);

        boolean result = notTake || take;
        if(result) dp[index][target] = 1;
        else dp[index][target] = 0;

        return result;
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*target) and SC = dp[n][target+1]
    public boolean canPartitionTabulation(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%2 != 0) return false;

        boolean[][] dp = new boolean[nums.length][sum/2+1];
        if(nums[0] < sum/2+1) dp[0][nums[0]] = true;
        for(int i=0;i<nums.length;i++)  dp[i][0] = true;

        for(int index=1;index<nums.length;index++){
            for(int target=1;target<=sum/2;target++){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(nums[index] <= target) take = dp[index-1][target-nums[index]];

                dp[index][target] = take || notTake;
            }
        }
        return dp[nums.length-1][sum/2];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*target) and SC = dp[target+1]
    public boolean canPartitionTabulationSpaceOptimization(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if(sum%2 != 0) return false;

        boolean[] prev = new boolean[sum/2+1];
        boolean[] curr = new boolean[sum/2+1];

        if(nums[0] < sum/2+1) prev[nums[0]] = true;
        prev[0] = true;

        for(int index=1;index<nums.length;index++){
            for(int target=1;target<=sum/2;target++){
                boolean notTake = prev[target];
                boolean take = false;
                if(nums[index] <= target) take = prev[target-nums[index]];

                curr[target] = take || notTake;
            }
            prev=curr;
            curr=new boolean[sum/2+1];
        }
        return prev[sum/2];
    }
}
