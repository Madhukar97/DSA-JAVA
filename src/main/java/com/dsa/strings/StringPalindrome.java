package com.dsa.strings;

//To check weather the given string is palindrome or not
public class StringPalindrome {

    public static void main(String[] args) {
        String str = "abcdcb";
        System.out.println(checkIsPalindrome(str));
    }

    static boolean checkIsPalindrome(String str) {
        if (str == null || str.length() == 0) return true;
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
