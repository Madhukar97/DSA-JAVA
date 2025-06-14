package com.stackandqueue;

import java.util.Stack;

//503. Next Greater Element II
//https://leetcode.com/problems/next-greater-element-ii/description/
public class NextGreaterElementII {
    //Optimal sol using stack with time O(2n) and space O(n)
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            if(i < n){
                if(stack.isEmpty()){
                    nge[i]=-1;
                }else{
                    nge[i] = stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        return nge;
    }

    //Revision 2
    //Optimal sol 2 using less easy code
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] nge = new int[nums.length];
            Stack<Integer> stack = new Stack<>();

            for(int i=nums.length-1;i>=0;i--) stack.add(nums[i]);

            for(int i=nums.length-1;i>=0;i--){
                while(!stack.isEmpty() && stack.peek() <= nums[i]){
                    stack.pop();
                }
                if(stack.isEmpty()) nge[i] = -1;
                else nge[i] = stack.peek();
                stack.add(nums[i]);
            }

            return nge;
        }
    }

    // Revision 5
    class Solution5 {
        public int[] nextGreaterElements(int[] nums) {
            int n=nums.length;
            int[] nge = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i=n-1;i>=0;i--) stack.push(nums[i]);

            for(int i=n-1;i>=0;i--){
                while(!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
                if(stack.isEmpty()) nge[i] = -1;
                else nge[i] = stack.peek();
                stack.push(nums[i]);
            }
            return nge;
        }
    }
}
