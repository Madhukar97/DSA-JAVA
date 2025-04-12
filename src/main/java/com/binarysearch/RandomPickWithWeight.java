package com.binarysearch;

import java.util.Random;

//528. Random Pick with Weight
//https://leetcode.com/problems/random-pick-with-weight/description/
public class RandomPickWithWeight {
    //Sol using prefixSum and BinarySearch
    class Solution {
        int[] arr;
        int[] prefixSum;
        Random random;

        public Solution(int[] w) {
            arr= w.clone();
            random = new Random();
            prefixSum=  new int[w.length];
            int prefix=0;
            for(int i=0;i<w.length;i++) {
                prefix+=w[i];
                prefixSum[i] = prefix;
            }
            // System.out.println("PRE : " + Arrays.toString(prefixSum));
        }

        public int pickIndex() {
            int index = random.nextInt(prefixSum[arr.length-1]);
            int s=0;
            int e=arr.length-1;
            while(s<=e){
                int mid = (s+e)/2;
                if(prefixSum[mid] <= index) s=mid+1;
                else e=mid-1;
            }
            return s;
        }
    }
}
