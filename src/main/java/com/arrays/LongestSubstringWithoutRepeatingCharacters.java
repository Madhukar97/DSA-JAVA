package com.arrays;

import java.util.Set;
import java.util.HashSet;

//Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    //optimal sol using hashing with time complexity O(n) and space O(n)
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        Set<Character> hashSet = new HashSet<>();
        int i=0;
        int j=0;
        int len=0;

        while(j<s.length()){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                len++;
                j++;
                maxLen = Math.max(len, maxLen);
            }else if(hashSet.contains(s.charAt(j))){
                while(i <= j){
                    hashSet.remove(s.charAt(i));
                    i++;
                    len--;
                    if(!hashSet.contains(s.charAt(j))) break;
                }
            }
        }
        return maxLen;
    }
}
