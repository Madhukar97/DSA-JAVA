package com.arrays;

import java.util.Arrays;

//167. Two Sum II - Input Array Is Sorted
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class TwoSum2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4},6)));
    }

    //Two pointer method O(n) time complexity with constant space
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1;
        int[] ans = new int[2];
        int sum = 0;

        while(l < r) {
            sum = numbers[l] + numbers[r];
            if(sum == target) {
                ans[0] = l+1;
                ans[1] = r+1;
            }
            if(sum > target) r--;
            else l++;
        }
        return ans;
    }
}
