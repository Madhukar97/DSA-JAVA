package com.arrays;

import java.util.Arrays;

//Amazon Interview question
public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,0,1,2};
        System.out.println(missingNumber(arr));
    }

    // Find missing number in 0 to n array using cyclic sort
    static int missingNumber(int[] arr) {
        int i=0;
        while ( i < arr.length ) {
            int correctIndex = arr[i];
            if ( arr[i] < arr.length && arr[correctIndex] != arr[i] ) {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }else i++;
        }

        //search the sorted array for which element is not in the respective index
        for (int j = 0; j < arr.length; j++) {
            if ( arr[j] != j) {
                return j;
            }
        }
        return arr.length;
    }
}
