package com.strings;

import java.util.Arrays;

//14. Longest Common Prefix
//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    //Brute force sol with time O(n*m) and space O(1)
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        String prefix = strs[0];

        for(int i=1;i<n;i++){
            int j=0;
            String curr = strs[i];
            while(j < Math.min(prefix.length(),curr.length()) && prefix.charAt(j) == curr.charAt(j)){
                j++;
            }
            prefix=curr.substring(0,j);
        }
        return prefix;
    }
    //optimal sol with time O(nlogn + m) and space O(1)
    public String longestCommonPrefixSol2(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];

        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i) != last.charAt(i)) return ans.toString();
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
