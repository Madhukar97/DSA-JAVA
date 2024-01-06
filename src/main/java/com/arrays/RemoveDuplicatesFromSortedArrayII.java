package com.arrays;

//80. Remove Duplicates from Sorted Array II
//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
public class RemoveDuplicatesFromSortedArrayII {
    //Optimal sol using 1 pointer
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i=0;
            for(int e : nums){
                if(i==0 || i==1 || nums[i-2] != e){
                    nums[i++] = e;
                }
            }
            return i;
        }
    }
}
