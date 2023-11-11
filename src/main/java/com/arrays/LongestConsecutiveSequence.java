package com.arrays;

import java.util.Arrays;

//128. Longest Consecutive Sequence
//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
    //Optimal sol time complexity O(nlog(n)) + O(n) and space O(1)
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        if(nums.length == 2){
            return nums[1]-nums[0] == 1 ? 2 : 1;
        }
        int i=0;
        int j=i+1;
        int ans=0;
        int count=1;
        while(j<nums.length){
            if(nums[j]-nums[j-1]==1){
                j++;
                count++;
            }
            else if(nums[j]-nums[j-1]==0){
                j++;
            }
            else{
                ans = Math.max(ans, count);
                i=j;
                j++;
                count=1;
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }

    //Optimal sol 2
    //Revision 2
    public int longestConsecutiveR2(int[] nums) {
        if(nums.length < 2) return nums.length;
        Arrays.sort(nums);

        int ans=1;
        int count=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]-1) {
                count++;
                ans = Math.max(ans,count);
            }else if(nums[i] == nums[i+1]){
                continue;
            }
            else count=1;
        }
        return ans;
    }
}
