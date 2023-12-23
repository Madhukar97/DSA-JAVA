package com.arrays;

//2404. Most Frequent Even Element
//https://leetcode.com/problems/most-frequent-even-element/description/
public class MostFrequentEvenElement {
    //Sol using Hashing
    class Solution {
        public int mostFrequentEven(int[] nums) {
            int[] a = new int[100001];

            for(int i=0;i<nums.length;i++){
                if(nums[i]%2 != 0) continue;
                int num = nums[i];
                a[num]++;
            }

            int maxFreq = 0;
            int maxIndex = -1;
            for(int i=0;i<a.length;i++){
                if(a[i] > maxFreq){
                    maxFreq=a[i];
                    maxIndex = i;
                }
            }
            int ans = maxIndex;
            for(int i=0;i<a.length;i++){
                if(i < maxIndex && a[i] == maxFreq){
                    ans = i;
                }
            }
            if(ans >= 0) return ans;
            return -1;
        }
    }
}
