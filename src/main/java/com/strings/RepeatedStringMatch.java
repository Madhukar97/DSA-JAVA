package com.strings;

//686. Repeated String Match
//https://leetcode.com/problems/repeated-string-match/description/
public class RepeatedStringMatch {
    //Rabin Karp algo with time O(n^2) and space O(1)
    public int repeatedStringMatch(String a, String b) {
        int n=b.length()/a.length();

        StringBuilder temp = new StringBuilder();
        for(int i=0; i<n; i++) temp.append(a);

        if(temp.toString().contains(b)) return n;
        temp.append(a);
        if(temp.toString().contains(b)) return n+1;
        temp.append(a);
        if(temp.toString().contains(b)) return n+2;
        return -1;
    }
}
