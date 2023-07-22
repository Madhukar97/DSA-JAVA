package com.dynamicprogramming.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//368. Largest Divisible Subset
//https://leetcode.com/problems/largest-divisible-subset/
//Striver DP series vid 44
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();

        Arrays.sort(nums);
        return rec(0, -1, nums, sub, ans);
    }
    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    //getting TLE error
    public List<Integer> rec(int i, int prevInd, int[] nums, List<Integer> sub, List<Integer> ans){
        if(i == nums.length){
            if(ans.size() < sub.size()){
                ans = sub.stream().collect(Collectors.toList());
            }
            return ans;
        }

        if(prevInd == -1 || nums[i] % sub.get(sub.size()-1) == 0){
            sub.add(nums[i]);
            List<Integer> take = rec(i+1, i, nums, sub, ans);
            sub.remove((Object)nums[i]);
            List<Integer> notTake = rec(i+1, prevInd, nums, sub, ans);
            if(take.size() > notTake.size()) return take;
            else return notTake;
        }
        return rec(i+1, prevInd, nums, sub, ans);
    }
    //Special solution DP(Bottom-up approach) with DP solution TC = O(n*Log(n) + n*n + n) , SC = dp[n]
    public List<Integer> largestDivisibleSubsetDP(int[] nums) {
        int[] dp = new int[nums.length+1];
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
        }
        Arrays.sort(nums);

        //Find LIS
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=-1;j<i;j++){
                if( j==-1 || nums[i]%nums[j] == 0 ){
                    dp[i+1] = Math.max(dp[i+1],dp[j+1]+1);
                    max=Math.max(max,dp[i+1]);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        int maxi=0;
        int pInd=nums.length;
        for(int i=nums.length;i>0;i--){
            if( dp[i]==max || dp[i] == maxi-1 && nums[pInd-1]%nums[i-1]==0) {
                max=max+1;
                ans.add(nums[i-1]);
                maxi = dp[i];
                pInd = i;
            }
        }

        // System.out.println(Arrays.toString(nums));
        // System.out.println(Arrays.toString(dp));
        return ans;
    }
}
