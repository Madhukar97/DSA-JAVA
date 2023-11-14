package com.strings;

import java.util.*;

//13. Roman to Integer
//https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {
    /*
    The key intuition lies in the fact that in Roman numerals,
    when a smaller value appears before a larger value, it represents subtraction,
    while when a smaller value appears after or equal to a larger value, it represents addition.
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            int curr = map.get(s.charAt(i));
            int next = map.get(s.charAt(i+1));
            if(curr < next){
                ans-=curr;
            }else{
                ans+=curr;
            }
        }
        ans+=map.get(s.charAt(s.length()-1));
        return ans;
    }

    //Revision 2
    public int romanToIntR2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans=0;
        int i=0;
        while(i<s.length()){
            if(i+1 < s.length() && map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                ans+=map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i+=2;
            }else{
                ans+=map.get(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}
