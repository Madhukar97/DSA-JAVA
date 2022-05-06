package com.strings;

//647. Palindromic Substrings
//https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    public static void main(String[] args) {

    }
    public int countSubstrings(String str) {
        int count=0;
        int s=0;
        int e=0;
        for(int i=0; i<str.length(); i++) {
            s=i;
            e=i;
            while(s>=0 && e<str.length() && str.charAt(s) == str.charAt(e)) {
                count++;
                s--;
                e++;
            }
        }for(int i=0; i<str.length(); i++) {
            s=i;
            e=i+1;
            while(s>=0 && e<str.length() && str.charAt(s) == str.charAt(e)) {
                count++;
                s--;
                e++;
            }
        }
        return count;
    }
}
