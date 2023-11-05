package com.math;

import java.util.Arrays;

//75. Sort Colors
//https://leetcode.com/problems/sort-colors/
// microsoft flipkart
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
//        if(nums.length == 2 && nums[0] < nums[1]) {
//            int temp = nums[0];
//            nums[0] = nums[1];
//            nums[1] = temp;
//        }
        int start = 0;
        int end = nums.length - 1;
        int current = 0;

        while(current <= end) {
            if(nums[current] == 2){
                nums[current] = nums[end];
                nums[end] = 2;
                end--;
            }
            else if(nums[current] == 1) {
                current++;
            }
            else {
                nums[current] = nums[start];
                nums[start] = 0;
                start++;
                current++;
            }
        }
    }

    //Revision 2
    public void sortColorsR2(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int k=0;

        while(i < j && k<=j){
            if(nums[i] == 0){
                i++;
                continue;
            }
            if(k<i){
                k=i;
                continue;
            }
            if(nums[k] == 1){
                k++;
                continue;
            }
            if(nums[k] == 2){
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                j--;
            }else if(nums[k] == 0){
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
            }
        }
    }
}
