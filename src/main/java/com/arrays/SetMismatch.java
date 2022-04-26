package com.arrays;

//645. Set Mismatch
public class SetMismatch {
    public static void main(String[] args) {

    }
    public int[] findErrorNums(int[] nums) {
        int[] ans = {0,0};
        int i = 0;
        int cIndex = 0;
        while(i < nums.length) {
            if(nums[i] != i+1) {
                cIndex = nums[i]-1;
                if(nums[cIndex] != cIndex+1) {
                    int temp = nums[cIndex];
                    nums[cIndex] = nums[i];
                    nums[i] = temp;
                }else i++;
            }else i++;
        }
        for( i=0; i< nums.length; i++) {
            if(nums[i] != i+1) {
                ans[0] = nums[i];
                ans[1] = i+1;
            }
        }
        return ans;
    }
}
