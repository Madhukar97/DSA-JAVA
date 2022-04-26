package com.dynamicprogramming;

import java.util.HashMap;

//268. Missing Number
//https://leetcode.com/problems/missing-number/
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int[] nums2 = {0,1};
        int[] nums3 = {1,2};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber2(nums2));
        System.out.println(missingNumber2(nums3));
        System.out.println(missingNumber2(nums3));
    }

    // cyclic sort method O(n^2) time complexity
    public static int missingNumber(int[] nums) {
        int ans = 0;
        int left = 0;
        int correctIndex = 0;
        int temp = 0;
        while(left < nums.length) {
            if(left != nums[left]){
                correctIndex = nums[left];
                if(correctIndex < nums.length && correctIndex != nums[correctIndex]) {
                    temp = nums[correctIndex];
                    nums[correctIndex] = nums[left];
                    nums[left] = temp;
                } else left++;
            }
            else left++;
        }
        for(int i=0; i<nums.length; i++) {
            if(i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    // dynamic programming method O(n) time complexity ans O(n) space complexity
    static int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int arrSum=0;
        for(int a : nums){
            arrSum += a;
        }
        int res = sum - arrSum;
        return res;
    }
}
