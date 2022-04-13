package com.dsa.recursion;

//Linear search of an array using recursion
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2,6,1,0,54};
        int target = 54;
        System.out.println(linearSearch(arr, target, 0));
    }

    static int linearSearch(int[] arr, int target, int index){
        if ( index == arr.length ) return -1;
        if ( target == arr[index] ) return index;
        else return linearSearch(arr, target, index+1);
    }
}
