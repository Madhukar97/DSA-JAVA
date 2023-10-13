package com.codestudio.binarysearch;

import java.util.Arrays;

//Aggressive Cows
//https://www.codingninjas.com/studio/problems/aggressive-cows_1082559?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class AggressiveCows {
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int min=1;
        int max=stalls[stalls.length-1]-stalls[0];
        int ans=0;

        while(min<=max){
            int mid = min+(max-min)/2;
            int cows=1;
            int lastCow=stalls[0];
            for(int i=1;i<stalls.length;i++){
                if(stalls[i]-lastCow >= mid){
                    cows++;
                    lastCow=stalls[i];
                }
            }
            if(cows<k){
                max=mid-1;
            }else{
                ans=mid;
                min=mid+1;
            }
        }
        return ans;
    }
}
