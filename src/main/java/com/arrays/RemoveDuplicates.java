package com.arrays;

import java.util.*;

//26. Remove Duplicates from Sorted Array
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int k = removeDuplicates(nums);
        System.out.println(k+"\n"+Arrays.toString(nums));

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(-3);
        set.add(4);

        for (int i : set) System.out.println("E : " + i);
        System.out.println("SET : " +set.toString());
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
