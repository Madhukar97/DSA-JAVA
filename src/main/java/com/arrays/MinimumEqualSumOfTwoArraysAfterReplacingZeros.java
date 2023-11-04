package com.arrays;

//2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
//https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/description/
public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        long c1=0;
        long c2=0;

        for(int n : nums1){
            sum1+=n;
            if(n == 0) c1++;
        }
        for(int n : nums2){
            sum2+=n;
            if(n==0) c2++;
        }

        if(c2==0 && sum1+c1 > sum2) return -1;
        if(c1==0 && sum2+c2 > sum1) return -1;
        return Math.max(sum1+c1,sum2+c2);
    }
}
