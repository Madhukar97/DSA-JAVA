package com.strings;

//389. Find the Difference
//https://leetcode.com/problems/find-the-difference/description/
public class FindTheDifference {
    //using hash array with TC = O(m+n) and SC = O(1)
    public char findTheDifference(String s, String t) {
        int[] hash = new int[26];

        for(int i=0;i<s.length();i++) hash[s.charAt(i)-'a']++;

        for(int i=0;i<t.length();i++){
            if(hash[t.charAt(i)-'a'] == 0) return t.charAt(i);
            else hash[t.charAt(i)-'a']--;
        }
        return 'a';
    }

    //Optimal sol Using bit manipulation with TC = O(m+n) and SC = O(1)
    public char findTheDifferenceSol2(String s, String t) {
        int ans = 0;
        for(int i=0;i<s.length();i++) ans^=s.charAt(i);
        for(int j=0;j<t.length();j++) ans^=t.charAt(j);

        return (char)ans;
    }
}
