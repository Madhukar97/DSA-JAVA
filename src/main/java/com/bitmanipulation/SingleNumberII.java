package com.bitmanipulation;

import java.util.*;

//137. Single Number II
//https://leetcode.com/problems/single-number-ii/description/
public class SingleNumberII {
    //Better sol using hashmap
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int val = 0;
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                val = map.get(nums[i]) +1;
                map.put(nums[i], val);
            }else map.put(nums[i], 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) == 1) return key;
        }
        return -1;
    }

    //Optimal sol using bit manipulation
    public int singleNumberSol2(int[] nums) {
        int ans = 0;

        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                int checkBit = nums[j] & (1<<i);
                if(checkBit != 0){
                    count++;
                }
            }
            if(count % 3 == 1){
                ans = ans + (1<<i);
            }
        }
        return ans;
    }
}
