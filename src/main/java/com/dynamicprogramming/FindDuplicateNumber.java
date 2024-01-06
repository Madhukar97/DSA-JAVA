package com.dynamicprogramming;

import java.util.HashMap;

//287. Find the Duplicate Number
//https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicateNumber {
    public static void main(String[] args) {

    }
    // dynamic programming method O(n) time complexity O(n) space complexity
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return nums[i];
            }
            else map.put(nums[i],1);
        }
        return 0;
    }

    //optimal solution O(n) time with O(1) space complexity
    public int findDuplicate2(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            else nums[Math.abs(nums[i])]*=-1;
        }
        return -1;
    }

    //Revision 2
    //Optimal sol O(n) time and O(1) space using -ve multiplication
    public int findDuplicate3(int[] nums) {
        for(int i : nums){
            int abs = Math.abs(i);
            if(nums[abs-1] > 0) nums[abs-1] = -nums[abs-1];
            else return abs;
        }
        return 0;
    }
}
