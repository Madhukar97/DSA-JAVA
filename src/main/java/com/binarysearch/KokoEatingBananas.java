package com.binarysearch;

//875. Koko Eating Bananas
//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBananas {
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left=1;
            int right=0;
            for(int p : piles){
                right=Math.max(right,p);
            }
            int minK=Integer.MAX_VALUE;
            while(left <= right){
                int mid = left + (right-left)/2;
                int hrs=0;
                for(int i=0;i<piles.length;i++){
                    int pile = piles[i];
                    if(pile%mid != 0) hrs+=pile/mid+1;
                    else hrs+=pile/mid;
                }
                if(hrs>0 && hrs <= h) minK = Math.min(minK, mid);
                if(hrs <= h) right=mid-1;
                else left=mid+1;
            }
            return minK;
        }
    }
}
