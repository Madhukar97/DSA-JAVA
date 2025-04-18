package com.slidingwindowtwopointer;

import java.util.*;

//424. Longest Repeating Character Replacement
//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    // Better sol with TC = O(N+N)*26 , SC = O(1)
    class Solution {
        public int characterReplacement(String s, int k) {
            int maxFreq = 0;
            int[] chars = new int[26];
            int l=0;
            int r=0;
            int maxLength=0;
            while(r < s.length()){
                chars[s.charAt(r)-'A']++;
                maxFreq = Math.max(maxFreq, chars[s.charAt(r)-'A']);
                while(r-l+1 - maxFreq > k){
                    chars[s.charAt(l++)-'A']--;
                    maxFreq = findMaxFreq(chars);
                }
                maxLength = Math.max(maxLength, r-l+1);
                r++;
            }
            return maxLength;
        }

        public int findMaxFreq(int[] chars){
            int max=0;
            for(int i : chars) max =  Math.max(max,i);
            return max;
        }
    }
    // Better sol 2 with TC = O(N+N) , SC = O(1)
    class Solution2 {
        public int characterReplacement(String s, int k) {
            int maxFreq = 0;
            int[] chars = new int[26];
            int l=0;
            int r=0;
            int maxLength=0;
            while(r < s.length()){
                chars[s.charAt(r)-'A']++;
                maxFreq = Math.max(maxFreq, chars[s.charAt(r)-'A']);
                while(r-l+1 - maxFreq > k){
                    chars[s.charAt(l++)-'A']--;
                    // maxFreq = findMaxFreq(chars);
                }
                maxLength = Math.max(maxLength, r-l+1);
                r++;
            }
            return maxLength;
        }

        public int findMaxFreq(int[] chars){
            int max=0;
            for(int i : chars) max =  Math.max(max,i);
            return max;
        }
    }
    // Better sol using HashMap
    class Solution3 {
        public int characterReplacement(String s, int k) {
            Map<Character, Integer> map = new HashMap<>();
            int i=0,j=0,max=0;
            while(j < s.length()){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                if(isValidWindow(map, k)) max = Math.max(max, j-i+1);
                else {
                    if(map.get(s.charAt(i)) == 1) map.remove(s.charAt(i));
                    else map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    i++;
                }
                j++;
            }
            return max;
        }

        private boolean isValidWindow(Map<Character, Integer> map, int k){
            int maxFreq = 0, totalFreq=0;
            for(int val : map.values()){
                totalFreq+=val;
                maxFreq = Math.max(maxFreq, val);
            }
            return totalFreq-maxFreq <= k;
        }
    }
}
