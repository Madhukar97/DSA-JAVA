package com.strings;

//38. Count and Say
//https://leetcode.com/problems/count-and-say/description/
public class CountAndSay {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s="1";
        for(int i=0;i<n-1;i++){
            int l=0;
            int r=0;
            String newStr="";
            while(l < s.length()){
                r=l;
                while(r<s.length() && s.charAt(l) == s.charAt(r)){
                    r++;
                }
                newStr=newStr+(r-l)+s.charAt(l);
                l=r;
            }
            s=newStr;
        }
        return s;
    }
    //Better sol using StringBuilder x4 faster than string+=
    public String countAndSaySol2(int n) {
        if(n==1) return "1";
        String s="1";
        for(int i=0;i<n-1;i++){
            int l=0;
            int r=0;
            StringBuilder newStr= new StringBuilder();
            while(l < s.length()){
                r=l;
                while(r<s.length() && s.charAt(l) == s.charAt(r)){
                    r++;
                }
                newStr.append((r-l)).append(s.charAt(l));
                l=r;
            }
            s=newStr.toString();
        }
        return s;
    }
}
