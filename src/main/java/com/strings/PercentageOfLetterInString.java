package com.strings;

//2278. Percentage of Letter in String
//https://leetcode.com/problems/percentage-of-letter-in-string/description/
public class PercentageOfLetterInString {
    public int percentageLetter(String s, char letter) {
        double count = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == letter) count++;
        }
        return (int)(count/(double)s.length()*100);
    }
}
