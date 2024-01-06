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

    //Revision 2

    public class Solution {

        public static int minCharsforPalindrome(String str) {
            for(int i=str.length()-1;i>=0;i--){
                if(isPal(str, 0, i)) return str.length()-i-1;
            }
            return -1;
        }

        public static boolean isPal(String str, int i, int j){
            while(i<=j) if(str.charAt(i++) != str.charAt(j--)) return false;
            return true;
        }

    }
}
