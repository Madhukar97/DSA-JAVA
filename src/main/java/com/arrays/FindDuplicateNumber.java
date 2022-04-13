package com.arrays;

//Find duplicate number in an array of n+1 terms having values from 1 to n
//Amazon interview question
public class FindDuplicateNumber {

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicateNumber(arr));
    }

    //finding duplicate number using cyclic sort
    static int findDuplicateNumber(int[] arr) {
        int i=0;

        while (i< arr.length){

            //check weather current index is having correct number or not
            //if not present calc the correct index for the element else move to next element
            if (arr[i] != i+1){
                int correctIndex = arr[i] -1 ;

                //if correct index doesn't contain correct element swap it or else it's the duplicate number
                if (arr[i] != arr[correctIndex]){
                    int temp = arr[correctIndex];
                    arr[correctIndex] = arr[i];
                    arr[i] = temp;
                }else
                    return arr[i];

            } else i++;
        }
        return -1;
    }
}
