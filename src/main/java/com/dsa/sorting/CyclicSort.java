package com.dsa.sorting;

import java.util.Arrays;

public class CyclicSort {

    // Cyclic sort only works for arrays having 1 to N numbers
    public static void main(String[] args) {
        int[] arr = {3,4,2,5,1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while ( i < arr.length -1 ) {
            int correctIndex = arr[i] -1;

            // if the number is not present in its index swap it to its index
            if ( arr[correctIndex] != arr[i]) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            } else i++;
        }
    }
}
