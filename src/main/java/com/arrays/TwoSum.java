package com.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//1. Two Sum
//https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {

    }

    // solution with O(n) time and O(n) space
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }
            else map.put(target-nums[i], i);
        }
        return ans;
    }

    public int[] twoSumGreedy2PointersMethod(int[] nums, int target) {
        int[] old = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int[] ans = new int[2];
        // System.out.println(Arrays.toString(old));
        while(left < right){
            if(nums[left]+nums[right] == target){
                for(int i=0;i<nums.length;i++){
                    if(nums[left] == old[i]) ans[0]=i;
                }
                for(int i=nums.length-1;i>=0;i--){
                    if(nums[right] == old[i]) ans[1]=i;
                }
                return ans;
            }else if(nums[left]+nums[right] < target) left++;
            else right--;
        }
        return ans;
    }

    //Revision 2
    //Sol using hashing
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])) return new int[]{map.get(target-nums[i]), i};
            else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0,0};
    }
}
