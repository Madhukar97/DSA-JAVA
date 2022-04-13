package com.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //sorting array in ascending order
    static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int lastIndex = arr.length - i -1;
            int maxIndex = 0;

            //find the max number index
            for (int j = 0; j < arr.length - i ; j++) {
                if (arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
            }

            //swap the greatest element into the correct position
            if (arr[maxIndex] > arr[lastIndex]) {
                int temp = arr[lastIndex];
                arr[lastIndex] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
}
