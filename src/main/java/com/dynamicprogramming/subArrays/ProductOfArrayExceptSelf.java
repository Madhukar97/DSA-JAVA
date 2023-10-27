package com.dynamicprogramming.subArrays;

//238. Product of Array Except Self
//https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {
    //Brute Force nested loops
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        for(int i=0; i<n; i++){
            int product = 1;
            for(int j=0; j<n; j++){
                if(i == j) continue;
                product *= nums[j];
            }
            output[i] = product;
        }
        return output;
    }

    //Most Optimal in single iteration timw O(n) ans space O(n)
    public int[] productExceptSelfSol2(int[] nums) {
        int[] ans = new int[nums.length];

        int pref=1, suff=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=pref;
            pref*=nums[i];
        }
        for(int i=nums.length-1;i>=0;i--){
            ans[i]*=suff;
            suff*=nums[i];
        }
        return ans;
    }
}
