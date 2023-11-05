package com.arrays;

//2216. Minimum Deletions to Make Array Beautiful
//https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/description/
public class MinimumDeletionsToMakeArrayBeautiful {
    public int minDeletion(int[] nums) {
        int n=nums.length;
        int deletions = 0;
        for(int i=0;i<n-1;i++){
            if(deletions%2 == 0 && i%2==0){
                if(nums[i] == nums[i+1]) deletions++;
            }else if(deletions%2 != 0 && i%2 != 0){
                if(nums[i] == nums[i+1]) deletions++;
            }
        }
        return (n-deletions)%2 == 0 ? deletions : deletions+1;
    }
}
