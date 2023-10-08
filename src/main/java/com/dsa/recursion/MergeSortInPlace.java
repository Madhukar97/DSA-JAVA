package com.dsa.recursion;

import java.util.Arrays;

//Merge sort using recursion by modifying the same array
public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        int[] arr2 = {4,1,3,9,7};
        int[] arr3 = {4,1,3,9,7};
        mergeSort(arr, 0, arr.length);
        mergeSort(arr2, 0, arr2.length);
        mergeSort2(arr3, 0, arr3.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }

    static void mergeSort(int[] arr, int s, int e) {
        if ( e - s == 1 ) return;
        int mid = (s+e)/2;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid, e);

        merge(arr, s, mid, e);
    }

    static void merge(int[] arr, int s, int mid, int e) {
        int[] mix = new int[e - s];
        int i=s, j=mid, k=0;
        while ( i < mid && j < e) {
            if ( arr[i] < arr[j] ) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            } k++;
        }
        while ( i < mid ) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while ( j < e ) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            arr[s+l] = mix[l];
        }
    }

    public static void mergeSort2(int[] nums, int start, int end){
        if(start >= end) return;
        int mid=(start+end)/2;
        mergeSort2(nums, start, mid);
        mergeSort2(nums, mid+1, end);
        merge2(nums, start, mid, end);
    }

    public static void merge2(int[] nums, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int p1=start;
        int p2=mid+1;
        int i=0;

        while(p1 <= mid && p2 <= end){
            if(nums[p1] < nums[p2]){
                temp[i] = nums[p1];
                p1++;
            }else{
                temp[i] = nums[p2];
                p2++;
            }
            i++;
        }

        while(p1 <= mid){
            temp[i] = nums[p1];
            p1++;
            i++;
        }

        while(p2 <= end){
            temp[i] = nums[p2];
            p2++;
            i++;
        }


        for (int k = start; k <= end ; k++) {
            nums[k] = temp[k-start];
        }

    }
}
