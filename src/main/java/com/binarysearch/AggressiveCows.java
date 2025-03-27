package com.binarysearch;

import java.util.Arrays;

//Aggressive Cows
//https://www.naukri.com/code360/problems/aggressive-cows_1082559?leftPanelTabValue=PROBLEM
public class AggressiveCows {
    public class Solution {
        public static int aggressiveCows(int []stalls, int k) {
            //    Write your code here.
            Arrays.sort(stalls);
            int min=1;
            int max=stalls[stalls.length-1];

            while(min <= max){
                int mid = min+(max-min)/2;
                int cows=1;
                int prevIndex=0;

                for(int i=0;i<stalls.length;i++){
                    if(Math.abs(stalls[i] - stalls[prevIndex]) >= mid){
                        cows++;
                        prevIndex = i;
                    }
                }
                if(cows >= k){
                    min=mid+1;
                }else max=mid-1;
            }
            return max;
        }
    }
}
