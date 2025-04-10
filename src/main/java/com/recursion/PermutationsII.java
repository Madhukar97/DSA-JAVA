package com.recursion;

import java.util.ArrayList;
import java.util.List;

//47. Permutations II
//https://leetcode.com/problems/permutations-ii/
public class PermutationsII {
    public static void main(String[] args) {

    }
    List<Integer> list;
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            if(!outer.contains(list)) outer.add(list);
            return;
        }

        for(int i=l; i<nums.length; i++) {
            if(i != l && nums[i] == nums[l]) continue;
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

    // Revision 5
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            int[] vis = new int[nums.length];
            List<List<Integer>> ans = new ArrayList<>();
            findAllPermutations(0, nums, ans, vis, new ArrayList<>());
            return ans;
        }

        private void findAllPermutations(int index, int[] nums, List<List<Integer>> ans, int[] vis, List<Integer> permutation) {
            if(permutation.size() == nums.length){
                if(!ans.contains(permutation)) ans.add(new ArrayList<>(permutation));
                return;
            }
            if(index == nums.length) return;
            // not pick
            findAllPermutations(index+1, nums, ans, vis, permutation);
            // pick
            if(vis[index] == 0) {
                vis[index]=1;
                permutation.add(nums[index]);
                findAllPermutations(0, nums, ans, vis, permutation);
                permutation.remove(permutation.size()-1);
                vis[index]=0;
            }
        }
    }
}
