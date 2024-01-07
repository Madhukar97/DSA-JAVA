package com.arrays;

import java.util.*;

//398. Random Pick Index
//https://leetcode.com/problems/random-pick-index/
public class RandomPickIndex {
    class Solution {
        int[] arr;
        Random random;

        public Solution(int[] nums) {
            arr=nums;
            random=new Random();
        }

        public int pick(int target) {
            List<Integer> indexes = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                if(arr[i] == target) indexes.add(i);
            }
            int randomIndex = indexes.get(random.nextInt(indexes.size()));
            return randomIndex;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
