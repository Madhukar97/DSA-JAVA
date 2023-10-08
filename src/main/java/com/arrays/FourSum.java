package com.arrays;

import java.util.*;

//18. 4Sum
//https://leetcode.com/problems/4sum/description/
public class FourSum {
    //Better solution using hashing with time complexity O(n^3) and space O(2*(no of quads)) + O(n)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Set<List<Integer>> quads = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> hashSet = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[k];
                    if(hashSet.contains((long)target-sum)){
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add((int)(target-sum));
                        quad.sort((o1,o2)->o1-o2);
                        quads.add(quad);
                    }
                    hashSet.add((long)nums[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> quad : quads) ans.add(quad);
        return ans;
    }

    //optimal sol using greedy 2 pointer method with time O(n^3) + O(nlog(n)) and space O(no of quads)
    public List<List<Integer>> fourSumUsing2Pointer(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i > 0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<n;j++){
                if(j > i+1 && nums[j]==nums[j-1])continue;
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = (long)nums[i]+(long)nums[j]+(long)nums[k]+(long)nums[l];
                    if((long)target < sum) l--;
                    else if((long)target > sum) k++;
                    else{
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[k]);
                        quad.add(nums[l]);
                        ans.add(quad);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }
            }
        }
        return ans;
    }
}
