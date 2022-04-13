package com.arrays;

import java.util.Arrays;

public class SumOfTwo {

    public static void main(String[] args) {
        SumOfTwo obj = new SumOfTwo();
        int[] ans = obj.twoSum(new int[]{3,2,4},6);
        System.out.println(Arrays.toString(ans));
    }

    public int[] twoSum(int[] nums, int target) {

        int x=0;
        int y = -1;
        int num1=0,num2=0;
        for (int i=0;i<=nums.length-2;i++){
            num1=nums[i];
            for (int j=i+1;j<=nums.length-1;j++){

                if(nums[i] + nums[j] == target) {
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        return new int[]{x,y};
    }
}
