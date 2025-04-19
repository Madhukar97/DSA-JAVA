package com.slidingwindowtwopointer;

import java.util.*;

// Longest Substring with At Most K Distinct Characters
//https://www.naukri.com/code360/problems/distinct-characters_2221410?leftPanelTabValue=PROBLEM
public class LongestSubstringWithAtMostKDistinctCharacters {
    public class Solution {
        public static int kDistinctChars(int k, String str) {
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
    // Revision 5
    public class Solution2 {

        public static int kDistinctChars(int k, String str) {
            int s=0,e=0,maxLength=0;
            Map<Character,Integer> map = new HashMap<>();
            while(e < str.length()){
                map.put(str.charAt(e), map.getOrDefault(str.charAt(e),0)+1);
                if(map.size() <= k) maxLength = Math.max(maxLength, e-s+1);
                else {
                    if(map.get(str.charAt(s)) == 1) map.remove(str.charAt(s));
                    else map.put(str.charAt(s), map.get(str.charAt(s))-1);
                    s++;
                }
                e++;
            }
            return maxLength;
        }

    }
}
