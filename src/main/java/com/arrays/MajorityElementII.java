package com.arrays;

import java.util.*;

//229. Majority Element II
//https://leetcode.com/problems/majority-element-ii/
public class MajorityElementII {
    public static void main(String[] args) {

    }

    // solution with O(n) time and O(n) space complexity
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i : nums) {
            if(map.containsKey(i)) map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }

        for(int key : map.keySet()) {
            if(map.get(key) > nums.length/3) ans.add(key);
        }
        return ans;
    }

    //most optimized solution with O(n) time and O(1) space complexity
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;
        int c1 = 0;
        int c2 = 0;

        for(int num : nums) {
            if(num == n1) c1++;
            else if(num == n2) c2++;
            else if(c1 == 0) {n1 = num; c1++;}
            else if(c2 == 0) {n2 = num; c2++;}
            else{
                c1--;
                c2--;
            }
        }

        c1 =0;
        c2 =0;
        for(int num : nums) {
            if(num == n1) c1++;
            if(num == n2) c2++;
        }
        if(c1 > nums.length/3) ans.add(n1);
        if(c2 > nums.length/3) ans.add(n2);
        return ans;
    }
}
