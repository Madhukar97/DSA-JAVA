package com.arrays;

import java.util.*;

//15. 3Sum
//https://leetcode.com/problems/3sum/
public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> ans = threeSum(new int[]{1,2,-2,-1});
        System.out.println(ans);
    }
    static public List<List<Integer>> threeSum(int[] nums) {
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
