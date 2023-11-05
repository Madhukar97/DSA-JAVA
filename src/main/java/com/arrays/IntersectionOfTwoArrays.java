package com.arrays;

import java.util.*;

//349. Intersection of Two Arrays
//https://leetcode.com/problems/intersection-of-two-arrays/description/
public class IntersectionOfTwoArrays {
    //Better sol with TC = O(m+n) and SC = O(m+n)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int n : nums1) set1.add(n);
        for(int n : nums2) if(set1.contains(n)) set2.add(n);

        int[] ans = new int[set2.size()];
        int i=0;
        for(int n : set2){
            ans[i++] = n;
        }
        return ans;
    }

    //Optimal sol without Set, TC = O(n) and SC = O(n)
    public int[] intersectionSol2(int[] nums1, int[] nums2) {
        int[] hashArray = new int[1000];
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums1.length;i++) if(hashArray[nums1[i]] == 0) hashArray[nums1[i]]++;
        for(int i=0;i<nums2.length;i++) if(hashArray[nums2[i]] != 0) {
            list.add(nums2[i]);
            hashArray[nums2[i]]--;
        }

        int[] ans = new int[list.size()];
        int i=0;
        for(int n : list){
            ans[i++] = n;
        }
        return ans;
    }
}
