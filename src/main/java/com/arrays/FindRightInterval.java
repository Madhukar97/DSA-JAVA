package com.arrays;

import java.util.*;

//436. Find Right Interval
//https://leetcode.com/problems/find-right-interval/
public class FindRightInterval {
    class Solution {
        public int[] findRightInterval(int[][] intervals) {
            int[] ans = new int[intervals.length];
            int i=0;
            for(int[] interval : intervals){
                int min=Integer.MAX_VALUE;
                int index=-1;
                int j=0;
                for(int[] right : intervals){
                    if(right[0] >= interval[1]){
                        if(right[0] < min){
                            min = right[0];
                            index=j;
                        }
                    }
                    j++;
                }
                ans[i++] = index;
            }
            return ans;
        }
    }

    //Most optimal sol using BinarySearch
    class Solution2 {
        public int[] findRightInterval(int[][] intervals) {
            int n = intervals.length;
            int[] arr = new int[n];
            int[] ans = new int[n];
            for(int i = 0; i < n; ++i)
                arr[i] = intervals[i][0];
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0; i < n; ++i)
                map.put(arr[i],i);
            Arrays.sort(arr);
            for(int i = 0; i < n; ++i){
                int val = binarySearch(arr,intervals[i][1]);
                if(val == -1)
                    ans[i] = -1;
                else
                    ans[i] = map.get(arr[val]);
            }
            return ans;
        }

        public int binarySearch(int[] arr, int target){
            int s=0;
            int e=arr.length-1;
            int ans=-1;
            while(s<=e){
                int mid=(s+e)/2;
                if(arr[mid] == target) return mid;
                else if(arr[mid] > target){
                    ans = mid;
                    e=mid-1;
                }else s=mid+1;
            }
            return ans;
        }
    }
}
