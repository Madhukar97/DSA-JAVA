package com.backtracking;

import java.util.*;

//216. Combination Sum III
//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {
    public static void main(String[] args) {

    }
    List<List<Integer>> outer = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        recFunc(nums, k, n, new ArrayList<>(), 0, 0);
        return outer;
    }

    void recFunc(int[] nums, int k, int target, List<Integer> inner, int index, int currentSum) {
        if(currentSum == target && inner.size() == k) {
            outer.add(new ArrayList<>(inner));
            return;
        }

        if(index == nums.length || currentSum > target) return;

        inner.add(nums[index]);
        recFunc(nums, k, target, inner, index+1, currentSum+nums[index]);
        inner.remove(inner.size()-1);
        recFunc(nums, k, target, inner, index+1, currentSum);
    }
}
