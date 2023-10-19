package com.codestudio.strings;

//Minimum Characters For Palindrome
//https://www.codingninjas.com/studio/problems/893000?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class MinimumCharactersForPalindrome {
    public static int minCharsforPalindrome(String str) {
        int ans=0;

        for(int i=0;i<str.length();i++){
            if(isPalindrome(str, 0 ,i)){
                ans=Math.max(ans, i+1);
            }
        }

        return str.length()-ans;
    }

    public static boolean isPalindrome(String str, int s, int e){
        while(s<=e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}
