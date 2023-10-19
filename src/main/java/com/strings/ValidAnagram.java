package com.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//242. Valid Anagram
//https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram {
    //Better sol using hashing with time O(n1 + n2) and space O(n1 + n2)
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0;i<t.length();i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }
        // System.out.println("MAP1 : "+map1.toString());
        // System.out.println("MAP2 : "+map2.toString());
        return map1.equals(map2);
    }

    //Better sol using arrays and sorting with time O(n1logn1 + n2logn2) and space O(n1 + n2)
    public boolean isAnagramSol2(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] char1 = new char[s.length()];
        char[] char2 = new char[t.length()];

        for(int i=0;i<Math.max(s.length(),t.length());i++){
            if(i<s.length()) char1[i]=s.charAt(i);
            if(i<t.length()) char2[i]=t.charAt(i);
        }

        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1,char2);
    }
    //Most Optimal sol using array with time O(n1 + n2) and space O(1)
    //beats 99%
    public boolean isAnagramSol3(String s, String t) {
        int[] count = new int[26];

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count[x - 'a']++;
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count[x - 'a']--;
        }

        // Check if any character has non-zero frequency
        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }

        return true;
    }
}
