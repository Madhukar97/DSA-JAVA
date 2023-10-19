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

    //Similar optimal solution without swapping or modifying the array
    //Time O(n!) and Space O(n!)
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        recFunc2(nums, 0, sub,ans);
        return ans;
    }

    public void recFunc2(int[] nums, int i, List<Integer> sub, List<List<Integer>> ans){
        if(i >= nums.length) {
            if(sub.size() == nums.length) ans.add(new ArrayList<>(sub));
            return;
        }

        //pick
        if(!sub.contains(nums[i])) {
            sub.add(nums[i]);
            recFunc2(nums, 0, sub, ans);
            sub.remove(sub.size()-1);
        }
        //not pick
        recFunc2(nums, i+1, sub, ans);
    }
}
