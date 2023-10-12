package com.arrays.binarysearch;

//Find Nth Root Of M
//https://www.codingninjas.com/studio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class FindNthRootOfM {
    public static int NthRoot(int n, int m) {
        int l=1; int h= m;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(Math.pow(mid, n)==m){
                return mid;
            }
            else if(Math.pow(mid, n)>m){
                h=mid-1;
            }
            else{l=mid+1;}
        }
        return -1;
    }
}
