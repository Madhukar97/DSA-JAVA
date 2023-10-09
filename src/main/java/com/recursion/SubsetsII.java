package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
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

    //Most optimal sol skipping duplicate sets with time O(nlog(n) + 2^n*n)  and space O(n)
    //time nlogn for sorting given array, 2^n for recursive calls and *n for copying subset into new List
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        recFunc2(nums, 0, new ArrayList<>(),ans);
        return ans;
    }

    public void recFunc2(int[] nums, int currInd, List<Integer> sub, List<List<Integer>> ans){
        List<Integer> subSet = new ArrayList<>(sub);
        ans.add(subSet);

        for(int i=currInd;i<nums.length;i++){
            if(i!=currInd && nums[i]==nums[i-1]) continue;
            sub.add(nums[i]);
            recFunc2(nums,i+1,sub,ans);
            sub.remove(sub.size()-1);
        }
    }
}
