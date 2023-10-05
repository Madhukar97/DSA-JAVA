package com.arrays;

import java.util.HashMap;
import java.util.Map;

//Subarray Sum Equals K
//https://leetcode.com/problems/subarray-sum-equals-k/description/?show=1
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println("ans = " + subarraySum(nums, 2));
    }
    //optimal sol using hashing with time O(n) and space O(n)
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        Map<Integer,Integer> prefixSumCounts = new HashMap<>();

        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum == k) count++;
            if(prefixSumCounts.containsKey(sum-k)) count+=prefixSumCounts.get(sum-k);
            prefixSumCounts.put(sum, prefixSumCounts.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
