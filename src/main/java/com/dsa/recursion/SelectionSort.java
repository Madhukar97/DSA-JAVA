package com.dsa.recursion;

import java.util.Arrays;

//Selection sort using recursion
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr) {
        sort(arr, 0, 0, arr.length-1);
    }

    static void sort(int[] arr, int i, int maxIndex, int lastIndex) {
        if ( lastIndex == 0 ) return;
        if ( i <= lastIndex ) {
            if ( arr[i] > arr[maxIndex] ) {
                maxIndex = i;
            }
            sort(arr, i+1, maxIndex, lastIndex);
        } else {
            int temp = arr[lastIndex];
            arr[lastIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
            sort(arr, 0, 0, lastIndex-1);
        }
    }
}
