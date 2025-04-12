package com.greedy;

//678. Valid Parenthesis String
//https://leetcode.com/problems/valid-parenthesis-string/description/
public class ValidParenthesisString {
    // Greedy sol based on possible range of combinations
    class Solution {
        public boolean checkValidString(String s) {
            int min=0,max=0;
            for(char ch : s.toCharArray()){
                if(ch == '('){
                    min++;
                    max++;
                }else if(ch == ')' && max > 0){
                    min--;
                    if(min < 0) min=0;
                    max--;
                }else if(ch == ')') return false;
                else {
                    min--;
                    if(min < 0) min=0;
                    max++;
                }
            }
            return min<=0 && 0 <= max;
        }
    }
}
