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
}
