package com.strings;

import java.util.*;

//187. Repeated DNA Sequences
//https://leetcode.com/problems/repeated-dna-sequences/description/
public class RepeatedDNASequences {
    class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> ans = new ArrayList<>();

            if(s.length() < 10) return new ArrayList<>();

            Map<String, Integer> map = new HashMap<>();
            for(int i=9;i<s.length();i++){
                String key = s.substring(i-9,i+1);
                // System.out.println("DNA : " + key);
                map.put(key, map.getOrDefault(key, 0)+1);
            }

            for(String key : map.keySet()){
                if(map.get(key) > 1) ans.add(key);
            }
            return ans;
        }
    }
}
