package com.greedy;

import java.util.Arrays;

//Minimum Number of Platforms
//https://www.codingninjas.com/studio/problems/minimum-number-of-platforms_799400?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
//https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
public class MinimumNumberOfPlatforms {
    public static int calculateMinPatforms(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms=1;
        int maxPlatforms=1;
        int i=1;
        int j=0;
        while(i<n){
            if(arr[i] <= dep[j]){
                platforms++;
                maxPlatforms=Math.max(maxPlatforms, platforms);
                i++;
            }
            else {
                platforms--;
                j++;
            }
        }
        return maxPlatforms;
    }

    // Revision 5
    class Solution {
        // Function to find the minimum number of platforms required at the
        // railway station such that no train waits.
        static int findPlatform(int arr[], int dep[]) {
            // add your code here
            Arrays.sort(arr);
            Arrays.sort(dep);
            int max =0;
            int i=0,j=0;
            while(j<dep.length){
                if(i<arr.length && arr[i] <= dep[j]){
                    i++;
                }else {
                    max = Math.max(max, i-j);
                    j++;
                }
            }
            return max;
        }
    }
}
