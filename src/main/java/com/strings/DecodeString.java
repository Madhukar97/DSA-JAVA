package com.strings;

import java.util.*;

//394. Decode String
//https://leetcode.com/problems/decode-string/
public class DecodeString {
    //Using Recursion
    class Solution {
        public String decodeString(String s) {
            char[] chars = s.toCharArray();
            Queue<Character> q = new LinkedList<>();
            for(char c : chars) q.add(c);
            return rec(q);
        }

        public String rec(Queue<Character> q){
            StringBuilder sb = new StringBuilder();
            int num=0;
            while(!q.isEmpty()){
                char ch = q.poll();
                if(Character.isDigit(ch)){
                    num = num*10+ch-'0';
                }else if(ch == '['){
                    String sub = rec(q);
                    for(int i=0;i<num;i++) sb.append(sub);
                    num=0;
                }else if(ch == ']') {
                    break;
                }
                else{
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
}
