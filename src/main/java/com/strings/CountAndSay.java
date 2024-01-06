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

    //Most optimal sol using Recursion and StringBuilder
    //Revision 1
    public String countAndSayR2(int n) {
        return rec( "1", n);
    }

    public String rec(String n, int count){
        if(count == 1) return n;
        StringBuilder newN = new StringBuilder();
        int i=0;
        int j=0;
        while(i<n.length() && j<=n.length()){
            if(j<n.length() && n.charAt(i) == n.charAt(j)){
                j++;
            }else{
                int len = j-i;
                newN.append(len).append(n.charAt(i));
                i=j;
            }
        }
        return rec(newN.toString(), count-1);
    }

    //Revision 2
    class Solution {
        public String countAndSay(int n) {
            return rec("1", n);
        }

        public String rec(String num, int n){
            if(n == 1) return num;

            int count = 1;
            char val = num.charAt(0);
            StringBuilder next = new StringBuilder();
            for(int i=1;i<num.length();i++){
                if(num.charAt(i) == val) count++;
                else{
                    next.append(count).append(val);
                    count=1;
                    val = num.charAt(i);
                }
            }
            next.append(count).append(val);
            return rec(next.toString(), n-1);
        }
    }
}
