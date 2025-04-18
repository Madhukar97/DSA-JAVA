package com.slidingwindowtwopointer;

import java.util.*;

//3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int ans = 0;
            int l=0,r=0;
            while(r < s.length()){
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
                if(r-l+1 == map.size()) ans = Math.max(ans, r-l+1);
                else {
                    if(map.get(s.charAt(l)) == 1) map.remove(s.charAt(l));
                    else map.put(s.charAt(l), map.get(s.charAt(l))-1);
                    l++;
                }
                r++;
            }
            return ans;
        }
    }

    // Using Set
    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int ans = 0;
            int l=0,r=0;
            while(l<=r && r < s.length()){
                if(!set.contains(s.charAt(r))){
                    set.add(s.charAt(r));
                    ans = Math.max(ans, set.size());
                    r++;
                }
                else {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            return ans;
        }
    }
}
