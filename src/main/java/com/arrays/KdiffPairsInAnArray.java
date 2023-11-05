package com.arrays;

import java.util.*;

//532. K-diff Pairs in an Array
//https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
public class KdiffPairsInAnArray {
    //Using HashSet
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        Set<List<Integer>> set = new HashSet<>();

        while(j<nums.length){
            if(i == j){
                j++;
                continue;
            }
            else if(Math.abs(nums[i]-nums[j]) == k) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[j]);
                pair.add(nums[i]);
                set.add(pair);
                j++;
            }else if(nums[j] - nums[i] < k){
                j++;
            }else{
                i++;
            }
        }
        return set.size();
    }
}
