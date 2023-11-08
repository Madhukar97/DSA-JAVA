package com.arrays;

import java.util.*;
import java.util.HashSet;

//Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    //optimal sol using hashing with time complexity O(2n) and space O(n)
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
    //Most optimal sol using hashing with time complexity O(n) and space O(n)
    public int lengthOfLongestSubstring2(String s) {
        int maxLen=0;
        Map<Character,Integer> hashMap = new HashMap<>();
        int i=0;
        int j=0;
        int len=0;

        while(j<s.length()){
            if(!hashMap.containsKey(s.charAt(j))){
                hashMap.put(s.charAt(j),j);
                len++;
                j++;
                maxLen = Math.max(len, maxLen);
            }else if(hashMap.containsKey(s.charAt(j))){
                int newI=0;
                newI=hashMap.get(s.charAt(j));
                while(i<=newI){
                    hashMap.remove(s.charAt(i));
                    i++;
                }
                i=newI+1;
                len=j-i;
            }
        }
        return maxLen;
    }

    //Optimal sol
    //Revision 2
    public int lengthOfLongestSubstringR2(String s) {
        if(s.length() < 2) return s.length();
        Set<Character> set = new HashSet<>();

        int max = 1;
        int i=0;
        int j=1;
        set.add(s.charAt(i));
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max = Math.max(max, j-i+1);
                j++;
            }else{
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        return max;
    }

    //Revision2 sol 2
    public int lengthOfLongestSubstringRS2(String s) {
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
                while(hashSet.contains(s.charAt(j))){
                    hashSet.remove(s.charAt(i));
                    i++;
                    len--;
                }
            }
        }
        return maxLen;
    }
}
