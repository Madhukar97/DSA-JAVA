package com.recursion;

import java.util.*;

//77. Combinations
//https://leetcode.com/problems/combinations/
public class Combinations {
    public static void main(String[] args) {

    }
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i =1; i<=n; i++) {
            nums[i-1] = i;
        }
        List<List<Integer>> outer = new ArrayList<>();
        recFunc(outer, 0, nums.length, nums, k);
        return outer;
    }

    void recFunc(List<List<Integer>> outer, int l,int r, int[] nums, int k) {
        if(l == r) {
            if(list.size()==k) {
                List<Integer> ans  = new ArrayList<>();
                for(int i: list) {
                    ans.add(i);
                }
                outer.add(ans);
            }
            return;
        }

        list.add(nums[l]);
        recFunc(outer, l+1, r, nums, k);
        list.remove(list.size()-1);
        recFunc(outer, l+1, r, nums, k);

    }
}
