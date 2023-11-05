package com.arrays;

import java.util.*;

//350. Intersection of Two Arrays II
//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
public class IntersectionOfTwoArraysII {
    //Optimal sol without HashSet and TC = O(m+n) and space O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] hashArray = new int[1001];
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums1.length;i++) hashArray[nums1[i]]++;
        for(int i=0;i<nums2.length;i++) if(hashArray[nums2[i]] != 0) {
            list.add(nums2[i]);
            hashArray[nums2[i]]--;
        }

        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++) ans[i] = list.get(i);
        return ans;
    }
}
