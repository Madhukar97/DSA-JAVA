package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find the disappeared numbers in the list of 1 to n numbers
//Google interview question
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] arr1 = {4,3,2,7,8,2,3,1};
        int[] arr2 = {1,1};
        System.out.println(findDisappearedNumbers(arr2));
    }

    static List<Integer> findDisappearedNumbers(int[] arr) {
        int i=0;
        List<Integer> missingNums = new ArrayList<>();

        //sort the array using cyclic sort
        while (i< arr.length){
            int correctIndex = arr[i] -1;

            //swap the number if it's not present in the correct index else move to next element
            if (arr[i] != arr[correctIndex]){
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }else i++;
        }

        //check for indexes not having correct numbers and add those numbers to missingList
        for (int j = 0; j < arr.length; j++) {
            if ( arr[j] != j+1){
                missingNums.add(j+1);
            }
        }
        return missingNums;
    }
}
