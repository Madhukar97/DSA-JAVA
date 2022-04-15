package com.dsa.recursion;

import java.util.Arrays;

// Quick sort using recursion
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if ( low >= high) return;
        int s = low;
        int e = high;
        int mid = s + (e-s)/2;
        int pivot = arr[mid];

        while ( s <= e ) {
             /*In case if there is any violation, by the end of while loops s will be at its violation index
              left of pivot and e will be at its violation index on the right-hand side
              */
            while ( arr[s] < pivot ) {
                s++;
            }
            while ( arr[e] > pivot ) {
                e--;
            }
            //If violations found swap it, move to next indexes
            if ( s < e ) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
            }
            s++;
            e--;
        }
        // After the pivot is at the correct index, make recursion calls on the left and right sub arrays
        quickSort(arr, low, e);
        quickSort(arr, s, high);
    }
}
