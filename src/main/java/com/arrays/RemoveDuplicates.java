package com.arrays;

import java.util.Arrays;

//26. Remove Duplicates from Sorted Array
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int k = removeDuplicates(nums);
        System.out.println(k+"\n"+Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int i = 1;
        int current = 0;
        while(i < nums.length){
            if(nums[i-1] != nums[i]){
                current++;
                nums[current] = nums[i];
                i++;
            }else i++;
        }
        return current+1;
    }
}
