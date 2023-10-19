package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40. Combination Sum II
//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public static void main(String[] args) {

    }

    //only possible brute force solution O(2^n) time complexity
    List<List<Integer>> outer = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        recFunc(candidates, target, new ArrayList<>(), 0, 0);
        return outer;
    }

    void recFunc(int[] candidates, int target, List<Integer> inner, int index, int currentSum) {
        if(currentSum == target) {
            List<Integer> list = new ArrayList<>(inner);
            outer.add(list);
            return;
        }

        if(index == candidates.length || currentSum > target) return;

        int prev = -1;
        for(int i=index; i<candidates.length; i++) {
            if(candidates[i] == prev) continue;
            inner.add(candidates[i]);
            recFunc(candidates, target, inner, i+1, currentSum+candidates[i]);
            inner.remove(inner.size()-1);
            prev = candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2Sol2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        recFuncSol2(0,candidates,target,new ArrayList<>(), ans);
        return ans;
    }

    public void recFuncSol2(int ind, int[] candidates, int target, List<Integer> comb, List<List<Integer>> ans){
        if(target == 0){
            List<Integer> inner = new ArrayList<>(comb);
            ans.add(inner);
            return;
        }

        if(ind >= candidates.length) return;

        for(int i=ind;i<candidates.length;i++){
            if(i != ind && candidates[i]==candidates[i-1]) continue;
            comb.add(candidates[i]);
            if(candidates[i] <= target)recFuncSol2(i+1,candidates,target-candidates[i],comb,ans);
            comb.remove(comb.size()-1);
        }
    }
}
