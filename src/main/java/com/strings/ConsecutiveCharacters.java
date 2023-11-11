package com.strings;

//1446. Consecutive Characters
//https://leetcode.com/problems/consecutive-characters/
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int max=1;
        int count=1;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
                max=Math.max(max,count);
            }else{
                count=1;
            }
        }
        return max;
    }
}