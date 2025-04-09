package com.slidingwindowtwopointer;

import java.util.HashMap;

// Longest Substring with At Most K Distinct Characters
//https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM
public class LongestSubstringWithAtMostKDistinctCharacters {
    public class Solution {

        public static int kDistinctChars(int k, String str) {
            // Write your code here
            HashMap<Character,Integer> map = new HashMap<>();
            int l=0;
            int r=0;
            int max=0;

            while(r < str.length()){
                map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0)+1);
                while(map.size() > k){
                    if(map.get(str.charAt(l)) == 1) map.remove(str.charAt(l));
                    else map.put(str.charAt(l), map.get(str.charAt(l))-1);
                    l++;
                }
                max = Math.max(max, r-l+1);
                r++;
            }
            return max;
        }

    }
}
