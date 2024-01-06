package com.recursion;

import java.util.*;

// Subset Sum
//https://www.codingninjas.com/studio/problems/subset-sum_3843086?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM
//https://practice.geeksforgeeks.org/problems/subset-sums2234/1
public class SubsetSum {
    public class Solution {
        public static ArrayList<Integer> subsetSum(int num[]) {
            ArrayList<Integer> ans = new ArrayList<>();
            rec(num, 0, ans, 0);
            Collections.sort(ans);
            return ans;
        }

        public static void rec(int[] nums, int index, ArrayList<Integer> ans, int subset){
            if(index == nums.length) {
                ans.add(subset);
                return;
            }

            //not pick
            rec(nums, index+1, ans, subset);
            //pick
            rec(nums, index+1, ans, subset+nums[index]);
        }

    }
}
