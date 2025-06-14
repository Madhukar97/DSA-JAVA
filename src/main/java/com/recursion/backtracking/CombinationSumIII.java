package com.recursion.backtracking;

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

    //Revision 2
    //Most optimal sol 0ms with TC = O(K*N) ans SC = O(K*N)
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] nums = {1,2,3,4,5,6,7,8,9};
            List<List<Integer>> ans = new ArrayList<>();
            rec(nums, 0, n, k, ans, new ArrayList<>());
            return ans;
        }

        public void rec(int[] nums, int index, int target, int size, List<List<Integer>> ans, List<Integer> comb){
            if(target == 0){
                if(comb.size() == size) ans.add(new ArrayList<>(comb));
                return;
            }
            if(index == nums.length) return;

            for(int i=index;i<nums.length;i++){
                if(nums[i] <= target){
                    comb.add(nums[i]);
                    rec(nums, i+1, target-nums[i], size, ans, comb);
                    comb.remove(comb.size()-1);
                }
            }
        }
    }
}
