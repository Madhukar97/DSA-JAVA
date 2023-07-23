package com.arrays;

//845. Longest Mountain in Array
//https://leetcode.com/problems/longest-mountain-in-array/description/
public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        if(arr.length<=2)return 0;
        int max=0;

        for(int i=1;i<arr.length-1;i++){
            int len=0;
            int left = checkLeft(arr, i);
            int right = checkRight(arr, i);
            if(left >1 && right >1) len = left + right-1;
            else len=0;
            // System.out.println(arr[i] + ", Mountain :: " + left + ", right :: " + right);
            max=Math.max(max,len);
        }
        if(max<=2) return 0;
        return max;
    }

    public int checkLeft(int[] arr, int i){
        int count=1;
        while(i >0){
            if(arr[i-1] < arr[i]){
                i--;
                count+=1;
            }
            else return count;
        }
        return count;
    }

    public int checkRight(int[] arr, int i){
        int count=1;
        while(i < arr.length-1){
            if(arr[i] > arr[i+1]) {
                i++;
                count+=1;
            }
            else return count;
        }
        return count;
    }
}
