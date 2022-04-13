package com.dsa.recursion;

// Binary search in rotated sorted array using recursion
public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {5,6,1,2,3,4};
        int target = 4;
        System.out.println(rotatedBinarySearch(arr, target, 0, arr.length-1));
    }

    static int rotatedBinarySearch(int[] arr, int target, int start, int end) {
        if ( start > end ) return -1;
        int mid = start + ( end-start )/2;
        if ( target == arr[mid] ) return mid;
        if ( arr[start] < arr[mid] && arr[start] <= target && target < arr[mid] ) {
            return rotatedBinarySearch(arr, target, start, mid-1);
        }
        if ( arr[start] > arr[mid] && arr[start] <= target  ) {
            return rotatedBinarySearch(arr, target, start, mid-1);
        }
        if ( arr[mid] < arr[end] && arr[mid] < target && target <= arr[end] ) {
            return rotatedBinarySearch(arr, target, mid+1, end);
        }
        else {
            return rotatedBinarySearch(arr, target, mid+1, end);
        }

    }
}
