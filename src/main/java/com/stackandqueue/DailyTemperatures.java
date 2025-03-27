package com.stackandqueue;

import java.util.Stack;

//739. Daily Temperatures
//https://leetcode.com/problems/daily-temperatures/description/
public class DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n=temperatures.length;
            int[] ans = new int[n];
            Stack<Integer> stack = new Stack<>();

            for(int i=0;i<n;i++){
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    int index = stack.pop();
                    ans[index] = i - index;
                }
                stack.push(i);
            }
            return ans;
        }
    }
}
