package com.arrays;

import java.util.*;

//26. Remove Duplicates from Sorted Array
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        int k = removeDuplicatesSol2(nums);
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
    //Better sol using hashing
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int index=0;

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                nums[index] = nums[i];
                index++;
            }else{
                continue;
            }
        }
        return set.size();
    }

    //Optimal sol using 2 pointer
    public static int removeDuplicatesSol2(int[] nums) {
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

    //Revision 2
    //optimal sol using 1 pointer
    class Solution {
        public int removeDuplicates(int[] nums) {
            int i=0;
            for(int e : nums){
                if(i==0 || nums[i-1] != e){
                    nums[i++] = e;
                }
            }
            return i;
        }
    }
}
