package com.arrays;

import java.util.Arrays;

//977. Squares of a Sorted Array
//https://leetcode.com/problems/squares-of-a-sorted-array/description/
public class SquaresOfASortedArray {
    //Brute Force
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i]*nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    //Optimal sol
    public int[] sortedSquaresSol2(int[] nums) {
        int[] ans = new int[nums.length];

        int l=0;
        int r=nums.length-1;

        for(int i=nums.length-1;i>=0;i--){
            int left = nums[l]*nums[l];
            int right = nums[r]*nums[r];
            if(left > right){
                ans[i] = left;
                l++;
            }else{
                ans[i] = right;
                r--;
            }
        }
        return ans;
    }
}
