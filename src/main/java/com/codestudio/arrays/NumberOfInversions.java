package com.codestudio.arrays;

import java.util.*;

//Number of Inversions
//https://www.codingninjas.com/studio/problems/number-of-inversions_6840276?leftPanelTabValue=PROBLEM
//https://www.codingninjas.com/studio/problems/count-inversions_615
public class NumberOfInversions {

    //Optimal Sol using merge sort
    public static int numberOfInversions(int []a, int n) {
        return mergeSort(a, 0, n-1);
    }

    public static int mergeSort(int[] arr, int low, int high){
        int count=0;
        if(low >= high) return count;
        int mid = (low+high)/2;
        count+=mergeSort(arr, low, mid);
        count+=mergeSort(arr, mid+1, high);
        count+=merge(arr, low, mid, high);
        return count;
    }

    public static int merge(int[] arr, int low, int mid, int high){
        int i=low;
        int j=mid+1;
        int count=0;

        List<Integer> temp = new ArrayList<>();
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp.add(arr[i++]);
            }else{
                count+=mid-i+1;
                temp.add(arr[j++]);
            }
        }

        while(i <= mid){
            temp.add(arr[i++]);
        }

        while(j <= high) temp.add(arr[j++]);

        for(int index=low,p=0;index<=high;index++){
            arr[index] = temp.get(p++);
        }
        return count;
    }
}
