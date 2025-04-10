package com.recursion.backtracking;

import java.util.*;

//39. Combination Sum
//https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {100,400,4,12};
        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(candidates, 400));
    }
    List<List<Integer>> outer = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> inner = new ArrayList<>();
        recFunc2(candidates, target, inner, 0, 0);
        return outer;
    }

    //brute force solution (time limit exceeded for large input)
    void recFunc(int[] candidates, int target, List<Integer> inner, int index, int currentSum) {
        if(currentSum > target) return;

        if(currentSum == target) {
            List<Integer> list = new ArrayList<>(inner);
            Collections.sort(list);
            if(!outer.contains(list)){ outer.add(list);
                System.out.println(list);
            }
            return;
        }

        for(int i : candidates) {
            if(target%i == 0) {
                int count = target/i;
                while(count>0) {
                    inner.add(i);
                    count--;
                }
                recFunc(candidates, target, inner, index+1, currentSum+i*target/i);
                count = target/i;
                while(count>0) {
                    inner.remove(inner.size()-1);
                    count--;
                }
            }
            inner.add(i);
            recFunc(candidates, target, inner, index+1, currentSum+i);
            inner.remove(inner.size()-1);
        }
    }

    // optimized solution with O(2^target) time complexity
    void recFunc2(int[] candidates, int target, List<Integer> inner, int index, int currentSum) {
        if(currentSum > target || index == candidates.length) return;

        if(currentSum == target) {
            List<Integer> list = new ArrayList<>(inner);
            outer.add(list);
            return;
        }
        int i=candidates[index];
        inner.add(i);
        recFunc2(candidates, target, inner, index, currentSum+i);
        inner.remove(inner.size()-1);
        recFunc2(candidates, target, inner, index+1, currentSum);
    }

    //Most optimized sol 2
    public List<List<Integer>> combinationSumSol2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recFuncSol2(0,candidates,target,new ArrayList<>(), ans);
        return ans;
    }

    public void recFuncSol2(int i, int[] candidates, int target, List<Integer> comb, List<List<Integer>> ans){
        if(i >= candidates.length) return;

        if(target == 0){
            List<Integer> inner = new ArrayList<>(comb);
            ans.add(inner);
            return;
        }

        //pick
        comb.add(candidates[i]);
        if(candidates[i] <= target)recFuncSol2(i,candidates,target-candidates[i],comb,ans);
        comb.remove(comb.size()-1);
        //not pick
        recFuncSol2(i+1,candidates,target,comb,ans);
    }

    //Optimal sol
    //Revision 2
    public List<List<Integer>> combinationSumR2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }

    public void rec(int[] nums, int index, int target, List<List<Integer>> ans, List<Integer> comb){
        if(target == 0){
            ans.add(new ArrayList<>(comb));
            return;
        }

        if(index == nums.length || target < 0) return;

        //pick
        comb.add(nums[index]);
        rec(nums, index, target-nums[index], ans, comb);
        //not pick
        comb.remove(comb.size()-1);
        rec(nums, index+1, target, ans, comb);
    }

    //Revision 3
    //Most optimal sol with 1ms and TC = O(2 ^ target) and SC = O(1)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            rec(candidates, 0, target, ans, new ArrayList<>());
            return ans;
        }

        public void rec(int[] nums, int index, int target, List<List<Integer>> ans, List<Integer> comb){
            if(target == 0){
                List<Integer> list = new ArrayList<>(comb);
                ans.add(list);
                return;
            }
            if(index == nums.length) return;

            for(int i=index;i<nums.length; i++){
                if(nums[i] <= target){
                    comb.add(nums[i]);
                    rec(nums, i, target-nums[i], ans, comb);
                    comb.remove(comb.size()-1);
                }
            }
        }
    }

    // Revision 5
    class Solution5 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            findCombinations(0, candidates, target, ans, new ArrayList<>());
            return ans;
        }

        public void findCombinations(int index, int[] nums, int target, List<List<Integer>> ans, List<Integer> combination){
            if(target == 0) {
                ans.add(new ArrayList<>(combination));
                return;
            }
            if(index == nums.length || target < 0) return;

            // not pick
            findCombinations(index+1, nums, target, ans, combination);
            // pick
            combination.add(nums[index]);
            findCombinations(index, nums, target-nums[index], ans, combination);
            combination.remove(combination.size()-1);
        }
    }
}
