package com.arrays;

import java.util.*;

//2248. Intersection of Multiple Arrays
//https://leetcode.com/problems/intersection-of-multiple-arrays/description/
public class IntersectionOfMultipleArrays {
    //Optimal sol without HashSet, TC = O(m*n) and space O(1)
    public List<Integer> intersection(int[][] nums) {
        int[] hashArray = new int[1001];

        for(int[] arr : nums){
            for(int i=0;i<arr.length;i++) hashArray[arr[i]]++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums[0].length;i++) {
            if(hashArray[nums[0][i]] == nums.length) ans.add(nums[0][i]);
        }
        Collections.sort(ans, (e1,e2)->e1-e2);
        return ans;
    }
}
