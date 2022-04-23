package com.problems;

import java.util.Stack;

//20. Valid Parentheses
//https://leetcode.com/problems/valid-parentheses/
public class ValidParanthesis {
    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else if(c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}
