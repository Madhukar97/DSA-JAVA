package com.arrays;

import java.util.*;

//2215. Find the Difference of Two Arrays
//https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int n : nums1) s1.add(n);
        for(int n : nums2) s2.add(n);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        for(int n1 : s1){
            if(!s2.contains(n1)) l1.add(n1);
        }
        ans.add(l1);
        List<Integer> l2 = new ArrayList<>();
        for(int n2 : s2){
            if(!s1.contains(n2)) l2.add(n2);
        }
        ans.add(l2);
        return ans;
    }
}
