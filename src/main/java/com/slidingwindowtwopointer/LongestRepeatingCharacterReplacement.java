package com.slidingwindowtwopointer;

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
}
