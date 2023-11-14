package com.strings;

//28. Find the Index of the First Occurrence in a String
//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/submissions/
public class FirstOccurrenceInAString {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int p1=0;
        int p2=0;
        int p3=0;
        while(p1 < haystack.length()){
            p2=p1;
            p3=0;
            if(haystack.charAt(p2) == needle.charAt(p3)){
                while(p2 < haystack.length() && p3 < needle.length()){
                    if(haystack.charAt(p2) == needle.charAt(p3)){
                        if(p3 == needle.length()-1) return p1;
                        p2++;
                        p3++;
                    }
                    else break;
                }
            }
            p1++;
        }
        return -1;
    }

    //Optimal sol using substring method
    public int strStrSol2(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int ans=-1;

        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)) {
                ans=i;
                break;
            }
        }
        return ans;
    }
}
