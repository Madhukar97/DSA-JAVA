package com.codestudio.dynamicprogramming.subsetssubsequences;

import java.util.ArrayList;
import java.util.List;

//https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?leftPanelTab=0
//Partition a set into two subsets such that the difference of subset sums is minimum
public class PartitionIntoTwoSubsetsTheDifferenceOfSubsetSumsIsMinimum {
    public static void main(String[] args) {
        int[] arr = new int[]{0 ,0, 0, 0, 0, 0, 0, 0, 0, 11, 32, 0, 0, 329, 0, 0, 0, 0, 0};
        minSubsetSumDifferenceSpaceOptimization(arr, 19);
    }

    public static int minSubsetSumDifference(int[] nums, int x) {
        int total=0;
        for(int n : nums) total+=n;
        if(total==0) return 0;

        List<Integer> anss = new ArrayList<>();
        rec(nums.length-1,nums,0,anss);

        int min = Integer.MAX_VALUE;
        for(int i : anss){
            min = Math.min(min, Math.abs(total-i-i));
        }
        return min;
    }

    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    public static void rec(int index, int[] nums, int sum, List<Integer> anss){
        if(index == 0) {
            anss.add(sum+nums[index]);
            return;
        }

        rec(index-1,nums,sum,anss);
        rec(index-1,nums,sum+nums[index],anss);
    }


    public static int minSubsetSumDifferenceMemoization(int[] nums, int x) {
        int total=0;
        for(int n : nums) total+=n;
        if(total==0) return 0;

        boolean[][] dp = new boolean[nums.length][total+1];

        List<Integer> anss = new ArrayList<>();
        recMem(nums.length-1,nums,0,anss,dp);

        int min = Integer.MAX_VALUE;
        for(int i : anss){
            min = Math.min(min, Math.abs(total-i-i));
        }
        return min;
    }

    //Recursion with Memoization(Top-Down approach) solution TC = O(n*total) , SC = O(n) + dp[n][total+1]
    public static void recMem(int index, int[] nums, int sum, List<Integer> anss, boolean[][] dp){
        if(index == 0) {
            anss.add(sum+nums[index]);
            return;
        }

        if(dp[index][sum+nums[index]]) return;

        recMem(index-1,nums,sum,anss,dp);
        recMem(index-1,nums,sum+nums[index],anss,dp);
        dp[index][sum+nums[index]] = true;
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*total) , SC = dp[n][total+1]
    public static int minSubsetSumDifferenceTabulation(int[] nums, int x) {
        int total=0;
        for(int n : nums) total+=n;

        boolean[][] dp = new boolean[nums.length][total+1];
        dp[0][nums[0]] = true;
        for(int i=0;i<nums.length;i++) dp[i][0] = true;

        for(int index=1;index<nums.length;index++){
            for(int target=1;target<=total;target++){
                boolean notTake = dp[index-1][target];
                boolean take=false;
                if(nums[index] <= target) take = dp[index-1][target-nums[index]];
                dp[index][target] = take || notTake;
//                System.out.println(" index : " + index + ", target :" + target + " val : " + dp[index][target]);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int s1 = 0;s1<=total;s1++ ){
            if(dp[nums.length-1][s1]){
//                System.out.println(" s1 :: " + s1);
                min = Math.min(min, Math.abs((total-s1)-s1));
            }
        }
        return min;
    }

    // //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*total) , SC = dp[total+1]
    public static int minSubsetSumDifferenceSpaceOptimization(int[] nums, int x) {
        int total=0;
        for(int n : nums) total+=n;
        if(total==0) return 0;

        boolean[] prev = new boolean[total+1];
        boolean[] curr = new boolean[total+1];

        if(nums[0]<=total) prev[nums[0]] = true;
        prev[0] = true;
        curr[0] = true;

        for(int index=1;index<nums.length;index++){
            for(int target=1;target<=total;target++){
                boolean notTake = prev[target];
                boolean take=false;
                if(nums[index] <= target) take = prev[target-nums[index]];
                curr[target] = take || notTake;
//                System.out.println(" index : " + index + ", target :" + target + " val : " + curr[target]);
            }
            prev=curr;
            curr=new boolean[total+1];
            curr[0] = true;
        }

        int min = Integer.MAX_VALUE;
        for(int s1 = 0;s1<=total/2;s1++ ){
            if(prev[s1]){
//                System.out.println(" s1 :: " + s1);
                min = Math.min(min, Math.abs((total-s1)-s1));
            }
        }
        return min;
    }
}
