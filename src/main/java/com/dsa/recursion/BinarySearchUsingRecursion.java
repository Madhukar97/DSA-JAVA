package com.dsa.recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,77,134,223};
        int target = 223;
        System.out.println(binarySearch(arr, target, 0, arr.length-1));
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = start + (end - start)/2;
        if (start > end) return -1;
        if (target == arr[mid]) return mid;
        if (target < arr[mid]) {
            return binarySearch(arr, target, start, mid-1);
        }
        else return binarySearch(arr, target, mid+1, end);
    }
}
