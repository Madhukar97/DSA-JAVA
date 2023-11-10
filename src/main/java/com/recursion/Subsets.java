package com.recursion;

import java.util.ArrayList;
import java.util.List;

//78. Subsets
//https://leetcode.com/problems/subsets/
public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    static List<Integer> inner = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        recFunc(nums, outer, 0, nums.length-1);
        return outer;
    }

    static void recFunc(int[] nums, List<List<Integer>> outer, int s, int e) {
        if(s > e) {
            List<Integer> list = new ArrayList<>();
            for(int i : inner) {
                list.add(i);
            }
            outer.add(list);
            return;
        }
        inner.add(nums[s]);
        recFunc(nums, outer, s+1, e);

        inner.remove(inner.size()-1);
        recFunc(nums, outer, s+1, e);
    }

    //Revision 2
    //Optimal sol
    public List<List<Integer>> subsetsR2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public void rec(int[] nums, int index, List<List<Integer>> ans, List<Integer> subset){
        if(index == nums.length) {
            List<Integer> sub = new ArrayList<>();
            for(int i : subset) sub.add(i);
            ans.add(sub);
            return;
        }

        //pick
        subset.add(nums[index]);
        rec(nums, index+1, ans, subset);
        //not pick
        subset.remove(subset.size()-1);
        rec(nums, index+1, ans, subset);
    }
}
