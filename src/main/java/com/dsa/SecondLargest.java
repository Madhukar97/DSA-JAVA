package com.dsa;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {3,5,22,55,12,34,18};
        System.out.println(secondLargest(arr));
    }

    static int secondLargest(int[] arr) {
        int largest=arr[0];
        int secondLargest=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > largest){
                secondLargest=largest;
                largest=arr[i];
            }else if (arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
