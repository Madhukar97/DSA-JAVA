package com.dsa.sorting;

import java.util.Arrays;

public class InsertionSort{

    public static void main(String[] args) {
        int[] arr = {1,-33,4,5,-2,0};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // sorting array in ascending order
    static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {

                // if current element is less than previous then swap otherwise break the loop
                if ( arr[j] < arr[j-1] ){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else break;
            }
        }
    }
}
