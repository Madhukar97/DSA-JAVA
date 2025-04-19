package com.slidingwindowtwopointer;

import java.util.*;

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
    // Revision 5
    class Solution2 {
        public int numberOfSubstrings(String s) {
            return countSubStrings(s, 3) - countSubStrings(s, 2);
        }
        private int countSubStrings(String s, int k){
            int l=0,r=0,count=0;
            Map<Character,Integer> map = new HashMap<>();
            while(r < s.length()){
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
                while(map.size() > k) {
                    if(map.get(s.charAt(l)) == 1) map.remove(s.charAt(l));
                    else map.put(s.charAt(l), map.get(s.charAt(l))-1);
                    l++;
                }
                if(map.size() <= k) count+=r-l+1;
                r++;
            }
            return count;
        }
    }

    class Solution3 {
        public int numberOfSubstrings(String s) {
            return countSubStrings(s, 3) - countSubStrings(s, 2);
        }
        private int countSubStrings(String s, int k){
            int l=0,r=0,count=0;
            int[] chars = new int[3];
            while(r < s.length()){
                chars[s.charAt(r)-'a']++;
                while(count(chars) > k) chars[s.charAt(l++)-'a']--;
                count+=r-l+1;
                r++;
            }
            return count;
        }
        private int count(int[] chars){
            int count=0;
            for(int c : chars) if(c > 0) count++;
            return count;
        }
    }
}
