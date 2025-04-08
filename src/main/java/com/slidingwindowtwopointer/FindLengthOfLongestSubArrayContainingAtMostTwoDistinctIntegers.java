package com.slidingwindowtwopointer;

import java.util.*;

//Find length of the longest subarray containing atmost two distinct integers
//https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
public class FindLengthOfLongestSubArrayContainingAtMostTwoDistinctIntegers {
    class Solution {
        public static int totalElements(Integer[] arr) {
            // code here
            Map<Integer,Integer> map = new HashMap<>();
            int max=0;
            int l=0;
            int r=0;
            while(r<arr.length){
                map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
                while(map.size() > 2){
                    if(map.get(arr[l]) == 1) map.remove(arr[l]);
                    else map.put(arr[l], map.get(arr[l])-1);
                    l++;
                }
                max = Math.max(max, r-l+1);
                r++;
            }
            return max;
        }
    }
}
