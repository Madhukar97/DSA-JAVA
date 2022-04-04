package com.arrays;

import java.util.ArrayList;
import java.util.List;

//Find the number that is missing and number that is duplicate in 1 to n Array
public class SetMissMatch {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        int[] arr1 = {1,1};
        System.out.println(missingSet(arr));
    }

    //Finding missing set using cyclic sort
    static List<Integer> missingSet(int[] arr) {
        int i=0;
        List<Integer> missingSet = new ArrayList<>();

        while ( i < arr.length ) {
            if ( arr[i] != i+1 ) {
                int correctIndex = arr[i] - 1 ;
                if ( arr[i] != arr[correctIndex] ) {
                    int temp = arr[correctIndex];
                    arr[correctIndex] = arr[i];
                    arr[i] = temp;
                } else {
                    missingSet.add( arr[i] );
                    missingSet.add( i+1 );
                    return missingSet;
                }
            } else i++;
        }
        missingSet.add(-1);
        missingSet.add(-1);
        return missingSet;
    }
}
