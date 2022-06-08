package com.arrays;

//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public static void main(String[] args) {

    }
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int ans = 0 ;

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];


        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        for(int i=0; i<n; i++) {
            ans+= Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}