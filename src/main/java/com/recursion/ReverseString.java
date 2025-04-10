package com.recursion;

//344. Reverse String
//https://leetcode.com/problems/reverse-string/description/
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            reverse(s, 0);
        }

        public void reverse(char[] s, int index){
            if(index >= s.length/2 ) return;
            char temp = s[index];
            s[index] = s[s.length-1-index];
            s[s.length-1-index] = temp;
            reverse(s, index+1);
        }
    }
}
