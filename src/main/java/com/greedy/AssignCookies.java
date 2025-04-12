package com.greedy;

import java.util.Arrays;

//455. Assign Cookies
//https://leetcode.com/problems/assign-cookies/description/
public class AssignCookies {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int ans=0;
            int i=0,j=0;
            while(i<g.length && j<s.length){
                if(s[j] >= g[i]) {
                    ans++;
                    j++;
                    i++;
                }
                else if(s[j] < g[i]) j++;
            }
            return ans;
        }
    }
}
