package com.binarysearch;

import java.util.List;

//Find Kth Rotation
//https://www.geeksforgeeks.org/problems/rotation4723/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=rotation
public class FindKthRotation {
    class Solution {
        public int findKRotation(List<Integer> arr) {
            // Code here
            int[] nums = new int[arr.size()];
            for(int i=0;i<arr.size();i++) nums[i] = arr.get(i);

            if(nums[0] < nums[nums.length-1]) return 0;
            int s=0;
            int e=nums.length-1;
            int n=nums.length;

            while(s<=e){
                int mid = s+(e-s)/2;
                if(mid-1 >=0 && nums[mid-1] > nums[mid]) return mid;
                if(mid+1 <n && nums[mid] > nums[mid+1]) return mid+1;

                if(nums[s] <= nums[mid]) s=mid+1;
                else e=mid-1;
            }
            return 0;
        }
    }
}
