package com.slidingwindowtwopointer;

import java.util.*;

//76. Minimum Window Substring
//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            Map<Character,Integer> mapT = new HashMap<>();
            for(char ch : t.toCharArray()) mapT.put(ch, mapT.getOrDefault(ch, 0)+1);
            // System.out.println("MAP T : " + mapT.toString());

            Map<Character,Integer> mapS = new HashMap<>();
            int l=0,r=0;
            String ans = s+s;
            while(r < s.length()){
                if(mapT.containsKey(s.charAt(r))) mapS.put(s.charAt(r), mapS.getOrDefault(s.charAt(r),0)+1);
                while(isValid(mapT, mapS)){
                    String subStr = s.substring(l,r+1);
                    if(subStr.length() < ans.length()) ans = subStr;
                    // System.out.println("MAP S : " + mapS.toString() + ", substr : " + subStr);
                    if(mapT.containsKey(s.charAt(l))) {
                        if(mapS.get(s.charAt(l)) == 1) mapS.remove(s.charAt(l));
                        else mapS.put(s.charAt(l), mapS.get(s.charAt(l))-1);
                    }
                    l++;
                }
                // System.out.println("MAP S : " + mapS.toString());
                r++;
            }
            if(ans.equals(s+s)) return "";
            return ans;
        }

        public boolean isValid(Map<Character,Integer> mapT, Map<Character,Integer> mapS){
            if(mapT.size() != mapS.size()) return false;
            for(char key : mapT.keySet()){
                if(mapT.get(key) > mapS.get(key)) return false;
            }
            return true;
        }
    }
}
