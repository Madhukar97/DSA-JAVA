package com.arrays;

//Find the first missing positive number in 1 to n array
//Amazon interview question/ leetcode hard
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1,2,0};
        int[] arr1 = {3,4,-1,1};
        System.out.println(firstMissingPositive(arr1));
    }

    //Sort the array using cyclic sort
    static int firstMissingPositive(int[] arr) {
        int i=0;
        while (i< arr.length){

            //if the element is positive and less than or equal to length of array
            // and not in the correct index then swap it otherwise move to next element
            if ( arr[i] > 0 && arr[i] <= arr.length && arr[i] != i+1 ){
                int correctIndex = arr[i] - 1 ;
                if ( arr[i] != arr[correctIndex] ){
                    int temp = arr[correctIndex];
                    arr[correctIndex] = arr[i];
                    arr[i] = temp;
                }
            } else i++;
        }

        //the first element which is not in the correct index will be having the first missing positive
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j+1) return j+1;
        } return arr.length+1;
    }

    //Most Optimal sol
    public int firstMissingPositiveSol2(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i < n){
            if(nums[i] <= 0 || nums[i] > n || nums[i] == nums[nums[i]-1]){
                i++;
                continue;
            }
            //swap to correct index
            int correctIndex = nums[i]-1;
            int temp = nums[i];
            nums[i] = nums[correctIndex];
            nums[correctIndex] = temp;
        }
        for(int j=0;j<n;j++) if(nums[j] != j+1) return j+1;
        return n+1;
    }
}
