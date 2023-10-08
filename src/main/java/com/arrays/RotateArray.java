package com.arrays;

//189. Rotate Array
//https://leetcode.com/problems/rotate-array/description/
public class RotateArray {
    //Brute force sol with time complexity O(k*n) and space O(1)
    public void rotate(int[] nums, int k) {
        int n=nums.length;

        for(int i=0;i<k%n;i++){
            int temp=nums[n-1];
            for(int j=n-1;j>0;j--){
                nums[j]=nums[j-1];
            }
            nums[0]=temp;
        }
    }

    //Most optimal sol with time O(2n) and space O(1)
    public void rotateSol2(int[] nums, int k) {
        int n=nums.length;
        k%=nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
