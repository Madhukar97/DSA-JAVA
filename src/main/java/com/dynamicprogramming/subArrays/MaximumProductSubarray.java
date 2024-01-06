package com.dynamicprogramming.subArrays;

import java.util.*;

//152. Maximum Product Subarray
//https://leetcode.com/problems/maximum-product-subarray/description/
public class MaximumProductSubarray {
    //Brute Sol will be O(n^3)
    //Brute force using recuriosn
    class Solution {
        public int maxProduct(int[] nums) {
            int[] ans = new int[1];
            ans[0] = Integer.MIN_VALUE;

            rec(nums, ans, 0);
            return ans[0];
        }

        public void rec(int[] nums, int[] ans, int index){
            if(index == nums.length) return;

            int product = nums[index];
            ans[0] = Math.max(ans[0], product);
            for(int i=index+1;i<nums.length;i++){
                product = product*nums[i];
                rec(nums, ans, i);
                ans[0] = Math.max(ans[0], product);
            }
        }
    }

    //Better Sol using nested loops with time O(n^2) and space O(1)
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int product=1;
            for(int j=i;j<nums.length;j++){
                product*=nums[j];
                ans=Math.max(ans,product);
            }
        }
        return ans;
    }

    //My sol
    //Optimal sol with time O(n + 2n) and space O(n + n);
    public int maxProductSol2(int[] nums) {
        if(nums.length == 1) return nums[0];
        int ans = Integer.MIN_VALUE;

        List<Integer> zeroIndex = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) zeroIndex.add(i);
        }

        int start = 0;
        for(int i : zeroIndex){
            int product = 1;
            product = calcProduct(nums, start, i-1);
            start = i+1;
            ans = Math.max(ans,Math.max(0,product));
        }
        if(zeroIndex.size() > 0){
            int product = 1;
            product = calcProduct(nums, start, nums.length-1);
            ans = Math.max(ans,Math.max(0,product));
        }

        else if(zeroIndex.size()==0){
            int product = calcProduct(nums, 0, nums.length-1);
            ans = Math.max(ans, product);
        }
        return ans;
    }

    public int calcProduct(int[] nums, int s, int e){
        if(s>e) return Integer.MIN_VALUE;
        if(s==e) return nums[s];
        List<Integer> negativeIndex = new ArrayList<>();
        int negativeCount = 0;
        int max = Integer.MIN_VALUE;

        for(int i=s;i<=e;i++){
            if(nums[i]<0){
                negativeCount++;
                negativeIndex.add(i);
            }
        }

        if(negativeCount %2 ==0 ){
            int product=1;
            for(int i=s;i<=e;i++) product*=nums[i];
            return product;
        }

        for(int i : negativeIndex){
            int prefixProduct = 1;
            for(int p=s;p<i;p++) prefixProduct*=nums[p];
            int suffixProduct = 1;
            for(int p=i+1;p<=e;p++) suffixProduct*=nums[p];
            max = Math.max(max,Math.max(prefixProduct,suffixProduct));
        }
        return max;
    }

    //Most Optimal with time O(n) and space O(1)
    public int maxProductSol3(int[] nums) {
        int ans = Integer.MIN_VALUE;

        int pref = 1, suff = 1;
        for(int i=0;i<nums.length;i++){
            if(pref==0) pref=1;
            if(suff==0) suff=1;
            pref*=nums[i];
            suff*=nums[nums.length-i-1];
            ans = Math.max(ans, Math.max(pref,suff));
        }
        return ans;
    }
}
