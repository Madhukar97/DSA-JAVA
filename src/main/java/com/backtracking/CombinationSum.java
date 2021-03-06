package com.backtracking;

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
}
