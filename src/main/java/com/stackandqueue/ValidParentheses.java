package com.stackandqueue;

import java.util.Stack;

//20. Valid Parentheses
//https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
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

    //Sol 2
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(stack.size()==0){
                return false;
            }
            else if(c == ')'){
                if(stack.peek() == '(') stack.pop();
                else return false;
            }else if(c == '}'){
                if(stack.peek() == '{') stack.pop();
                else return false;
            }else if(c == ']'){
                if(stack.peek() == '[') stack.pop();
                else return false;
            }
        }
        return stack.size()==0;
    }

    //Revision 2
    public boolean isValidR2(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else stack.push(ch);
        }
        return stack.isEmpty();
    }
}
