package com.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//90. Subsets II
//https://leetcode.com/problems/subsets-ii/
public class SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    static List<Integer> inner = new ArrayList<>();
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
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
            Collections.sort(list);
            if(!outer.contains(list)) outer.add(list);
            return;
        }
        inner.add(nums[s]);
        recFunc(nums, outer, s+1, e);

        inner.remove(inner.size()-1);
        recFunc(nums, outer, s+1, e);
    }
}
