package com.arrays;

import java.util.*;

//15. 3Sum
//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> ans = threeSumOptimal(new int[]{1,2,-2,-1});
        System.out.println(ans);
    }
    //Better sol using Hashing with time O(n^2) and space O(m)
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<nums.length-2;i++){
            int n1=nums[i];
            List<Integer> triplet = new ArrayList<>();
            Set<Integer> hashSet = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int n2 = nums[j];
                if(hashSet.contains(-(n1+n2))){
                    triplet.add(n1);
                    triplet.add(n2);
                    triplet.add(-(n1+n2));
                    triplet.sort((o1,o2) -> o1-o2);
                    set.add(triplet);
                    triplet = new ArrayList<>();
                }
                hashSet.add(n2);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> list : set){
            ans.add(list);
        }
        return ans;
    }

    //Most optimal sol using 2 pointers with time O(n^2) and space O(1)
    static public List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set  = new HashSet<>();
        List<List<Integer>> outer = new ArrayList<>();
        for(int i=0; i<nums.length - 2; i++) {
            if(!set.contains(nums[i])) {
                twoSum(nums, -nums[i], i+1, outer);
                set.add(nums[i]);
            }
        }
        return outer;
    }

    static void twoSum(int[] nums, int target, int start, List<List<Integer>> outer) {
        List<Integer> inner;
        int s = start;
        int e = nums.length-1;
        Set<Integer> set  = new HashSet<>();
        while(s < e) {
            int sum = nums[s] + nums[e];
            if(sum == target && !set.contains(nums[s])) {
                inner = new ArrayList<>();
                inner.add(-target);
                inner.add(nums[s]);
                inner.add(nums[e]);
                outer.add(inner);
                e--;
                set.add(nums[s]);
            }
            else if ( sum > target ) e--;
            else s++;
        }
    }

}
