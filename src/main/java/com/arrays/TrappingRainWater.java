package com.arrays;

//42. Trapping Rain Water
//https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public static void main(String[] args) {

    }
    //Better sol using array with time O(n) and space O(2n)
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
    //Optimal sol using 2 pointer method with time O(n) and space O(1)
    public int trap2(int[] height) {
        int vol=0;
        int left=0;
        int right=height.length-1;
        int leftMax=0;
        int rightMax=0;

        while(left <= right){
            if(height[left] < height[right]){
                if(height[left] > leftMax) leftMax=height[left];
                else vol+=leftMax-height[left];
                left++;
            }
            else{
                if(height[right]>rightMax) rightMax=height[right];
                else vol+=rightMax-height[right];
                right--;
            }
        }
        return vol;
    }
}
