package com.slidingwindowtwopointer;

//1358. Number of Substrings Containing All Three Characters
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
public class NumberOfSubstringsContainingAllThreeCharacters {
    class Solution {
        public int numberOfSubstrings(String s) {
            int l=0,r=0,count=0;
            int[] chars = new int[3];
            chars[s.charAt(r)-'a']++;

            while(r < s.length()){
                if(l<=r && findCount(chars) == 3) {
                    count+=s.length()-r;
                    chars[s.charAt(l++)-'a']--;
                }
                else {
                    r++;
                    if(r < s.length()) chars[s.charAt(r)-'a']++;
                }
            }
            return count;
        }

        public int findCount(int[] chars){
            int count=0;
            for(int i : chars) if(i > 0) count++;
            return count;
        }
    }
}
