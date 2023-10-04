package com.codestudio.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Longest Subarray With Sum K
//https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?leftPanelTab=0
public class LongestSubarrayWithSumK {
    //Better hashing sol when -1000 <= arr[i] <= 1000, time O(n) and space O(n)
    //not most optimal when 0 <= arr[i] <= 1000
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

    //Most optimal greedy 2 pointer sol when 0 <= arr[i] <= 1000, time O(2n) and space O(1)
    public static int longestSubarrayWithSumK(int []a, long k) {
        int i=0;
        int j=0;
        long sum=a[0];
        int maxLen=0;

        while(j < a.length){
            while(i<=j && sum > k){
                sum-=a[i];
                i++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen, j-i+1);
            }
            j++;
            if(j<a.length) sum+=a[j];
        }
        return maxLen;
    }
}
