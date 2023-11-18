package com.stackandqueue;

import java.util.Stack;

//32. Longest Valid Parentheses
//https://leetcode.com/problems/longest-valid-parentheses/description/
public class LongestValidParentheses {
    /*
    Here the approach is nothing but we are using a stack
    and when we encounter an opening brace then we push the index of it into the stack
    and whenever we touch a closing brace then we see the top of the stack if it's size is one
    then it means the closing braces have dominated the opening brace.
    We then edit the top value of the stack to the index of the closing brace.
    else if stack size is > 1 then we compute the len = max(ans, i-stack.peek())
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else {
                if(stack.size() == 1){
                    stack.pop();
                    stack.push(i);
                }else{
                    stack.pop();
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }
}
