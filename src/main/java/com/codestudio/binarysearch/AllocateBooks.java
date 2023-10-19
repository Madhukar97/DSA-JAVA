package com.codestudio.binarysearch;

//Allocate Books
//https://www.codingninjas.com/studio/problems/ayush-gives-ninjatest_1097574?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class AllocateBooks {
    //hard Binary Search question
    //Most optimal sol
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        long max=0;
        long min=0;
        for(int t : time) {
            max+=t;
            min=Math.max(min,t);
        }
        long ans=Long.MAX_VALUE;

        while(min <= max){
            long mid = min+(max-min)/2;
            long secs=0;
            int day=1;
            for(int i=0;i<time.length;i++){
                if(secs+time[i] <= mid)secs+=time[i];
                else{
                    day++;
                    secs=time[i];
                }
            }
            if(day<=n)ans=Math.min(ans, mid);
            if(day>n)min=mid+1;
            else max=mid-1;
        }
        return ans;
    }
}
