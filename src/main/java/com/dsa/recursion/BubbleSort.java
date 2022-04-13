package com.dsa.recursion;

import java.util.Arrays;

// Sorting array using bubble sort in recursion
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    static void sort(int[] arr, int i, int last) {
        if (last == 0) return;
        if( i < last ) {
            if ( arr[i] > arr[i+1] ) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            sort(arr, i+1, last);
        } else sort(arr, 0, last-1);
    }
}
