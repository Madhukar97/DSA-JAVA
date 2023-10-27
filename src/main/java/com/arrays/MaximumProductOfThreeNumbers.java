package com.arrays;

//Maximum Product of Three Numbers
//https://leetcode.com/problems/maximum-product-of-three-numbers/description/
public class MaximumProductOfThreeNumbers {
    //Brute Force try all possibilities using recursion or nested loops
    //TLE
    public int maximumProduct(int[] nums) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        rec(nums, 0, 0, 1, ans);
        return ans[0];
    }

    public void rec(int[] nums, int index, int count, int product, int[] ans){
        if(count == 3) {
            ans[0] = Math.max(ans[0], product);
        }
        if(index == nums.length) return;

        rec(nums, index+1, count+1, product*nums[index], ans);
        rec(nums, index+1, count, product, ans);
    }

    //Optimal sol
    public int maximumProductSol2(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(max1 < nums[i]){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }else if (max2 < nums[i]){
                max3=max2;
                max2=nums[i];
            }else if(max3 < nums[i]){
                max3=nums[i];
            }

            if(min1 > nums[i]){
                min2=min1;
                min1=nums[i];
            }else if(min2 > nums[i]){
                min2=nums[i];
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }

    //Most optimal when edge case and for each loop are used
    public int maximumProductSol3(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for(int num : nums){
            if(max1 < num){
                max3=max2;
                max2=max1;
                max1=num;
            }else if (max2 < num){
                max3=max2;
                max2=num;
            }else if(max3 < num){
                max3=num;
            }

            if(min1 > num){
                min2=min1;
                min1=num;
            }else if(min2 > num){
                min2=num;
            }
        }
        return Math.max(max1*max2*max3, min1*min2*max1);
    }
}
