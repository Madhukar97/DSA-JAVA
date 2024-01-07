package com.arrays;

//1470. Shuffle the Array
//https://leetcode.com/problems/shuffle-the-array/description/
public class ShuffleTheArray {
    //Better sol
    class Solution {
        public int[] shuffle(int[] nums, int n) {
            int[] ans = new int[2*n];
            int index=0;
            for(int i=0;i<n;i++){
                ans[index++] = nums[i];
                ans[index++] = nums[i+n];
            }
            return ans;
        }
    }

    //Optimal sol with constant extra space SC = O(1)
    class Solution2 {
        public int[] shuffle(int[] nums, int n) {
            int i=0;
            int j=n;

            while(j<2*n){
                int start=i+1;
                int temp = nums[j];
                int end=j;
                while(end > i+1) {
                    nums[end] = nums[end-1];
                    end--;
                }
                nums[start] = temp;
                i=i+2;
                j++;
            }
            return nums;
        }
    }
}
