package com.arrays;

import java.util.ArrayList;
import java.util.List;

//Find all duplicate numbers in 1 to n array
//Amazon/ Microsoft interview question
public class FindAllDuplicates {

    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findAllDuplicates(arr));
    }

    //Finding duplicates using cyclic sort
    static List<Integer> findAllDuplicates(int[] arr) {
        int i=0;
        List<Integer> duplicates = new ArrayList<>();

        //check weather the current index is having correct number
        //if not calc the correct index or else move to next element
        while (i< arr.length) {
            if (arr[i] != i+1){
                int correctIndex= arr[i] - 1 ;

                //if the correct index doesn't contain correct element swap it or else it's a duplicate
                if (arr[i] != arr[correctIndex]){
                    int temp = arr[correctIndex];
                    arr[correctIndex] = arr[i];
                    arr[i] = temp;
                } else {

                    //before adding duplicate numbers into the list check if its already added and also move to the next element
                    if (!duplicates.contains(arr[i])) {
                        duplicates.add(arr[i]);
                    }
                    i++;
                }
            } else i++;
        }
        return duplicates;
    }
}
