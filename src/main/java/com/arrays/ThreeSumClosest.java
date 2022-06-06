package com.arrays;

import java.util.Arrays;

//16. 3Sum Closest
//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,1,-1,-1,3}, -1));
        System.out.println(diff);
    }
    static int diff = Integer.MAX_VALUE;
    static int ans = 0;

    // solution with O(n^3) time complexity and O(1) space
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            twoSum(nums, target, i+1, nums[i]);
        }
        return ans;
    }

    static void twoSum(int[] nums, int target, int start, int first) {
        int s = start;
        int e = nums.length-1;

        for(int i=s; i<nums.length-1; i++) {
            for(int j =i+1; j<nums.length; j++) {

                int sum = nums[i] + nums[j] + first ;

                if( Math.abs(sum-target) < diff) {
                    diff = Math.abs(sum-target);
                    ans = sum;
                }
            }
        }
    }


    // solution with O(n^2) time complexity and O(1) space - two pointers method
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            if(i > 0 && nums[i-1] == nums [i]) continue;
            int a_pointer = i+1;
            int b_pointer = nums.length-1;

            while(a_pointer < b_pointer) {
                int sum = nums[i]+nums[a_pointer]+nums[b_pointer];
                if(sum > target) b_pointer--;
                else a_pointer++;

                if(Math.abs(sum-target) < diff) {
                    diff = Math.abs(sum-target);
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
