package com.arrays;

import java.util.Arrays;

//31. Next Permutation
//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
        int[] arr2 = {2,3,1};
        int[] arr3 = {1,2,3};
        int[] arr4 = {1,3,2};
        nextPermutation(arr);
        nextPermutation(arr2);
        nextPermutation(arr3);
        nextPermutation(arr4);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
    }
    public static void nextPermutation(int[] nums) {
        int pivot = -1;
        for(int i=nums.length-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                pivot = i-1;
                break;
            }
        }
        int max = Integer.MAX_VALUE;
        int index = pivot+1;
        if(pivot != -1) {
            for (int i=pivot+1; i < nums.length; i++) {
                if(nums[i] > nums[pivot] && nums[i] < max) {
                    max = nums[i];
                    index = i;
                }
            }

            int temp = nums[index];
            nums[index] = nums[pivot];
            nums[pivot] = temp;
            Arrays.sort(nums, pivot+1, nums.length);
        }
        else Arrays.sort(nums);
    }

    //Revision 2
    public void nextPermutationR2(int[] nums) {
        int pivot = -1;
        int n=nums.length;

        for(int i=n-1;i>0;i--){
            if(nums[i-1] < nums[i]){
                pivot = i-1;
                break;
            }
        }
        //If there is no pivot reverse the array and return
        if(pivot == -1){
            for(int i=0;i<n/2;i++){
                int temp = nums[i];
                nums[i] = nums[n-i-1];
                nums[n-i-1] = temp;
            }
            return;
        }
        //find the min element from right which is just greater than pivot
        int minInd = n-1;
        int min = Integer.MAX_VALUE;
        for(int i=n-1;i>pivot;i--){
            if(nums[i] > nums[pivot] && nums[i] < min){
                min = nums[i];
                minInd = i;
            }
        }
        //swap with the min element from right which is just greater than pivot
        int temp = nums[pivot];
        nums[pivot] = nums[minInd];
        nums[minInd] = temp;
        //sort the right part and return
        Arrays.sort(nums, pivot+1, n);
    }
}
