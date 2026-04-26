package com.arrays;


//283. Move Zeroes
//https://leetcode.com/problems/move-zeroes/description/
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int l=0,r=0;
        while(r < n){
            while(r<n && (l>=r || nums[r]==0)) r++;
            if(nums[l] != 0) l++;
            else if(r<n) {
                nums[l]=nums[r];
                nums[r]=0;
                l++;
                r++;
            }
        }
    }
}
