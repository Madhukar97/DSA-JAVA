package com.dynamicprogramming.strings;

//5. Longest Palindromic Substring
//https://leetcode.com/problems/longest-palindromic-substring/description/
public class LongestPalindromicSubstring {
    //Most optimal sol with time O(n^2) and space O(1)
    public String longestPalindrome(String s) {
        int l=0;
        int r=0;
        int n=s.length();

        String ans="";
        int maxLen = 0;

        for(int i=0;i<n;i++){
            //check for odd palindromes
            l=i;
            r=i;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                String str = s.substring(l,r+1);
                if(r-l+1 > maxLen){
                    ans=str;
                    maxLen=r-l+1;
                }
                l--;
                r++;
            }
            //check for even palindromes
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                String str = s.substring(l,r+1);
                if(r-l+1 > maxLen){
                    ans=str;
                    maxLen=r-l+1;
                }
                l--;
                r++;
            }
        }
        return ans;
    }
}
