package com.recursion;

import java.util.ArrayList;
import java.util.List;

//46. Permutations
//https://leetcode.com/problems/permutations/
public class Permutations {
    public static void main(String[] args) {

    }
    List<Integer> list;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        recFunc(outer, 0, nums.length-1, nums);
        return outer;
    }

    void recFunc(List<List<Integer>> outer, int l,int r, int[] nums) {
        if(l == r) {
            list = new ArrayList<>();
            for(int i : nums) {
                list.add(i);
            }
            outer.add(list);
            return;
        }

        for(int i=l; i<nums.length; i++) {
            swap(nums,l,i);
            recFunc(outer, l+1, r, nums);
            swap(nums,l,i);
        }
    }

    void swap(int[] nums, int l, int i){
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }
}
