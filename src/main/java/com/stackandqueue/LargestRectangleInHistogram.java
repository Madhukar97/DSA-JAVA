package com.stackandqueue;

import java.util.Stack;

//84. Largest Rectangle in Histogram
//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestRectangleInHistogram {
    //optimal 1 sol using stack and Next Smaller Element method with time O(2n+2n+n) and space O(n+n+n)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nseLeft = new int[n];
        int[] nseRight = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nseLeft[i]=0;
            }else{
                nseLeft[i]=stack.peek()+1;
            }
            stack.push(i);
        }
        // System.out.println(Arrays.toString(nseLeft));
        stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nseRight[i]=n-1;
            }else{
                nseRight[i]=stack.peek()-1;
            }
            stack.push(i);
        }
        // System.out.println(Arrays.toString(nseRight));
        int ans=0;
        for(int i=0;i<n;i++){
            int area = (nseRight[i]-nseLeft[i]+1)*heights[i];
            ans=Math.max(ans,area);
        }
        return ans;
    }
    //optimal 2 sol using stack and Next Smaller Element method with time O(2n) and space O(n)
    public int largestRectangleAreaSol2(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack = new Stack<>();
        int ans=0;

        for(int i=0;i<=n;i++){
            while(!stack.isEmpty() && (i==n || heights[stack.peek()] >= heights[i])){
                int height = heights[stack.peek()];
                stack.pop();
                int width;
                if(stack.isEmpty()) width=i;
                else width = i - stack.peek() -1;
                ans = Math.max(ans, height*width);
            }
            stack.push(i);
        }
        return ans;
    }

    // Revision 5
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] nse = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i=n-1;i>=0;i--){
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
                if(stack.isEmpty()) nse[i] = n;
                else nse[i] = stack.peek();
                stack.push(i);
            }

            stack = new Stack<>();
            int[] pse = new int[n];
            for(int i=0;i<n;i++){
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
                if(stack.isEmpty()) pse[i] = -1;
                else pse[i] = stack.peek();
                stack.push(i);
            }
            int maxArea = 0;
            // System.out.println("NSE : " + Arrays.toString(nse));
            // System.out.println("PSE : " + Arrays.toString(pse));
            for(int i=0;i<n;i++) maxArea = Math.max(maxArea, (nse[i]-pse[i]-1)*heights[i]);
            return maxArea;
        }
    }
}
