package com.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;

//260. Single Number III
//https://leetcode.com/problems/single-number-iii/
public class SingleNumber3 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber3(nums)));
        System.out.println("res : " + (4 & -4));
        System.out.println("res2 : " + (4 & (4-1) ^ 4));
        System.out.println("res : " + (5 & -5));
        System.out.println("res2 : " + (5 & (5-1) ^ 5));
        System.out.println("res : " + (5 & 5));
        System.out.println("res : " + (5 & 5));
    }

    //  method for O(n) time complexity and O(n) space complexity
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = {-1,-1};
        int val =0;
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                val = map.get(nums[i]);
                map.put(nums[i], val+1);
            }else map.put(nums[i], 1);
        }
        int j=0;
        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                ans[j] = key;
                j++;
            }
        }
        return ans;
    }

    // optimized solution O(n) time ans O(1) space
    public static int[] singleNumber3(int[] nums) {
        int xor = 0;
        int[] ans = new int[2];
        for(int i=0; i< nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int firstBit = xor & (xor -1) ^ xor;
        int num1 = 0;
        for(int n : nums) {
            int x = n&firstBit;
            if( x == 0) num1 = num1^n;
        }
        ans[0] = num1;
        ans[1] = num1 ^ xor;

        return ans;
    }

    //Revision 2
    //Optimal sol
    public int[] singleNumberSol2(int[] nums) {
        int xor = 0;
        int[] ans = new int[2];
        for(int i=0; i< nums.length; i++) {
            xor = xor ^ nums[i];
        }
        // Get its last set bit
        xor = xor & -xor;

        for(int n : nums){
            if((n & xor) == 0) ans[0]^=n;
            else ans[1]^=n;
        }
        return ans;
    }
}
