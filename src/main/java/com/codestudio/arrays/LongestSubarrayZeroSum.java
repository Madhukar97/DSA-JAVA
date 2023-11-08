package com.codestudio.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Longest Subarray Zero Sum
//https://www.codingninjas.com/studio/problems/920321?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class LongestSubarrayZeroSum {
    //Most optimal sol when -1000 <= arr[i] <= 1000, time O(n) and space O(n)
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        int n=arr.size();
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        int sum=0;
        int maxLen=0;

        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            if(sum == 0){
                maxLen = Math.max(maxLen, i+1);
            }
            if(prefixSumMap.containsKey(sum)){
                maxLen = Math.max(maxLen, i-prefixSumMap.get(sum));
            }
            if(!prefixSumMap.containsKey(sum)){
                prefixSumMap.put(sum,i);
            }
        }
        return maxLen;
    }

    //Optimal sol for +ve's and -ve's
    //Revision 2
    public static int LongestSubsetWithZeroSumR2(ArrayList<Integer> arr) {
        int n=arr.size();
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        int sum=0;
        int maxLen=0;

        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            if(sum == 0){
                maxLen = Math.max(maxLen, i+1);
            }
            if(prefixSumMap.containsKey(sum)){
                maxLen = Math.max(maxLen, i-prefixSumMap.get(sum));
            }
            if(!prefixSumMap.containsKey(sum)){
                prefixSumMap.put(sum,i);
            }
        }
        return maxLen;
    }
}
