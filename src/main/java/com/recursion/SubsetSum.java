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

        public static void rec(int[] nums, int index, ArrayList<Integer> ans, int subsetSum){
            if(index == nums.length) {
                ans.add(subsetSum);
                return;
            }

            //not pick
            rec(nums, index+1, ans, subsetSum);
            //pick
            rec(nums, index+1, ans, subsetSum+nums[index]);
        }
    }
    // Revision 5
    class Solution2 {
        public ArrayList<Integer> subsetSums(int[] arr) {
            // code here
            ArrayList<Integer> ans = new ArrayList<>();
            findAllCombinations(0, arr, ans, 0);
            return ans;
        }

        private void findAllCombinations(int index, int[] nums, ArrayList<Integer> ans, int sum){
            if(index == nums.length){
                ans.add(sum);
                return;
            }

            // not pick
            findAllCombinations(index+1, nums, ans, sum);
            // pick
            findAllCombinations(index+1, nums, ans, sum+nums[index]);
        }
    }

}
