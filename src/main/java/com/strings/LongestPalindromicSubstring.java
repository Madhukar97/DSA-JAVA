package com.strings;

//5. Longest Palindromic Substring
//https://leetcode.com/problems/palindrome-partitioning/submissions/
public class LongestPalindromicSubstring {
    public static void main(String[] args) {

    }
    int size = 0;
    String ans = "";
    public String longestPalindrome(String s) {
        if(s.length() <2) return s;
        //recFunc("", s);
        //dfs(0, s);
        isPal(s);
        return ans;
    }

    // brute force solution
//     void recFunc(String pross, String str) {

//         if(str.length() == 0){
//             if(pross.length() > 0 && pross.length() > size && isPal(pross) ) {
//                 size = pross.length();
//                 ans = pross;
//             }
//             return;
//         }

//         recFunc(pross+str.charAt(0), str.substring(1));
//         recFunc("", str.substring(1));
//         recFunc(pross,"");
//     }

//     boolean isPal(String str) {
//         int s=0;
//         int e=str.length()-1;
//         while(s<e) {
//             if(str.charAt(s) != str.charAt(e)) return false;
//             s++;
//             e--;
//         }
//         return true;
//     }

    //slightly optimized solution O(n^2) time complexity
    void dfs(int start, String s) {
        if (start >= s.length()) {
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (end-start+1 > size && isPalindrome(s, start, end)) {
                size = end-start;
                ans = s.substring(start, end + 1);
                dfs(end + 1, s);
            }
        }
    }

    boolean isPalindrome(String pross, int s, int e) {
        while(s<e){
            if(pross.charAt(s++) != pross.charAt(e--)) return false;
        }
        return true;
    }

    //most optimized solution
    void isPal(String str) {
        int s=0;
        int e=0;
        for(int i=0; i<str.length(); i++) {
            s = i;
            e = i;
            while(s >=0 && e < str.length() && str.charAt(s) == str.charAt(e) ) {
                if(e-s >= size) {
                    size = e-s;
                    ans = str.substring(s,e+1);
                }
                s--;
                e++;
            }
        }
        for(int i=0; i<str.length(); i++) {
            s = i;
            e = i+1;
            while(s >=0 && e < str.length() && str.charAt(s) == str.charAt(e) ) {
                if(e-s >= size) {
                    size = e-s;
                    ans = str.substring(s,e+1);
                }
                s--;
                e++;
            }
        }
    }

    //Optimal sol
    //Revision 2
    public String longestPalindromeR2(String s) {
        int n = s.length();
        String ans = "";

        for(int i=0;i<n;i++){
            int l=i;
            int r=i;
            while(l >=0 && r<n){
                if(s.charAt(l) == s.charAt(r)){
                    String newS = s.substring(l,r+1);
                    if(ans.length() < newS.length()) ans = newS;
                    l--;
                    r++;
                }else break;
            }
        }
        for(int i=0;i<n-1;i++){
            int l=i;
            int r=i+1;
            while(l >=0 && r<n){
                if(s.charAt(l) == s.charAt(r)){
                    String newS = s.substring(l,r+1);
                    if(ans.length() < newS.length()) ans = newS;
                    l--;
                    r++;
                }else break;
            }
        }
        return ans;
    }
}
