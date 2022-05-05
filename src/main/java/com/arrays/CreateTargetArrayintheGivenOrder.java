package com.arrays;

//1389. Create Target Array in the Given Order
//https://leetcode.com/problems/create-target-array-in-the-given-order/
public class CreateTargetArrayintheGivenOrder {
    public static void main(String[] args) {

    }

    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        int nextIndex = 0;
        for(int i=0; i<nums.length; i++) {
            ans[i] = -1;
        }

        for(int i=0; i<nums.length; i++){
            if(ans[index[i]] == -1) ans[index[i]] = nums[i];
            else {
                rightShift(ans, index[i]);
                ans[index[i]] = nums[i];
            }
        }
        return ans;
    }

    void rightShift(int[] ans, int i){
        int p = ans.length-1;

        while(p > i) {
            int temp = ans[p-1];
            ans[p-1] = ans[p];
            ans[p] = temp;
            p--;
        }
    }
}
