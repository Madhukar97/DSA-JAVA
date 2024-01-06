package com.strings;

import java.util.Arrays;

//165. Compare Version Numbers
//https://leetcode.com/problems/compare-version-numbers/description/
public class CompareVersionNumbers {
    public static void main(String[] args) {
        compareVersion("0.1","1.1");
    }
    //Better sol using arrays time O(max(n1,n2)) and space O(n1 + n2)
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int pts1=0;
        int pts2=0;

        for(int i=0;i<Math.max(arr1.length,arr2.length);i++){
            int v1=0;
            int v2=0;
            if(i < arr1.length) v1 = Integer.parseInt(arr1[i]);
            if(i < arr2.length) v2 = Integer.parseInt(arr2[i]);
            if(v1 > v2) return 1;
            else if(v1 < v2) return -1;
        }
        return 0;
    }

    //Most optimal sol by comparing each revision version without Split operation
    //Revision 1
    public int compareVersionSol2(String v1, String v2) {
        for(int i=0,j=0,m=0,n=0;i<v1.length() || j<v2.length(); i++,j++){
            m=0;
            n=0;
            while(i < v1.length() && v1.charAt(i) != '.') m=m*10+v1.charAt(i++)-'0';
            while(j < v2.length() && v2.charAt(j) != '.') n=n*10+v2.charAt(j++)-'0';
            if(m < n) return -1;
            if(m > n) return 1;
        }
        return 0;
    }

    //Revision 2
    class Solution {
        public int compareVersion(String version1, String version2) {
            int i1=0;
            int j1=0;
            int i2=0;
            int j2=0;

            while(j1 < version1.length() || j2 < version2.length()){
                int v1=0;
                int v2=0;

                while(j1 < version1.length() && version1.charAt(j1) != '.') j1++;
                while(j2 < version2.length() && version2.charAt(j2) != '.') j2++;
                if(i1 != j1) v1 = Integer.parseInt(version1.substring(i1,j1));
                if(i2 != j2) v2 = Integer.parseInt(version2.substring(i2,j2));
                if(v1 < v2) return -1;
                else if(v1 > v2) return 1;
                j1++;
                j2++;
                i1=j1;
                i2=j2;
            }
            return 0;
        }
    }
}
