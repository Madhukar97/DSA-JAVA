package com.dynamicprogramming;

import java.util.Stack;

//456. 132 Pattern
//https://leetcode.com/problems/132-pattern/
public class LC132Pattern {
    public static void main(String[] args) {

    }

    // Dynamic programming solution using stack
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] < third) return true;
            while(!stack.isEmpty() && stack.peek() < nums[i]) third=stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
