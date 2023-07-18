package com.dynamicprogramming.strings;

//1312. Minimum Insertion Steps to Make a String Palindrome
//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int[] prev = new int[s.length()+1];
        int[] curr = new int[s.length()+1];

        String rev = "";
        for(int i=s.length()-1;i>=0;i--) rev = rev + s.charAt(i);

        for(int i1=1;i1<s.length()+1;i1++){
            for(int i2=1;i2<s.length()+1;i2++){
                if(i1==0 || i2==0) curr[i2] = 0;
                else if(s.charAt(i1-1) == rev.charAt(i2-1)) curr[i2] = 1+prev[i2-1];
                else curr[i2] = Math.max(prev[i2], curr[i2-1]);
            }
            prev = curr;
            curr = new int[s.length()+1];
        }
        return s.length()-prev[s.length()];
    }
}
