package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//169. Majority Element
//https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public static void main(String[] args) {

    }

    // solution with O(n) time and O(n) space
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums) {
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }

        int max = 0;
        int ans = 0;
        for(int key : map.keySet()) {
            int val = map.get(key);
            if(val > max) {
                max = val;
                ans = key;
            }
        }
        return ans;
    }

    // solution with O(nlog(n)) and O(1) space complexity
    public int majorityElement2(int[] nums) {

        Arrays.sort(nums);

        int max = 0;
        int ans = nums[0];
        int count = 0;
        for(int i=0 ;i<nums.length-1 ; i++) {
            if(nums[i] == nums[i+1]) {
                count++;
                if(count > max) {
                    max = count;
                    ans = nums[i];
                }
            }
            else {
                count = 0;
            }
        }
        return ans;
    }

    //optimized solution with O(n) time and O(1) space complexity
    public int majorityElement3(int[] nums) {

        int ans = nums[0];
        int count = 0;

        for(int i : nums) {
            if(ans == i) {
                count++;
            }
            else {
                count--;
                if(count == 0) {
                    ans= i;
                    count = 1;
                }
            }
        }
        return ans;
    }
}
