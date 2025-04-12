package com.stackandqueue;

import java.util.Stack;

//85. Maximal Rectangle
//https://leetcode.com/problems/maximal-rectangle/description/
public class MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int r=matrix.length;
            int c=matrix[0].length;
            int[] histogram = new int[c];
            int maxRect = 0;
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(matrix[i][j] == '1') histogram[j]++;
                    else histogram[j]=0;
                }
                maxRect = Math.max(maxRect, findMaxRect(histogram));
            }
            return maxRect;
        }

        public int findMaxRect(int[] heights){
            Stack<Integer> stack = new Stack<>();
            int n=heights.length;
            int[] nse = new int[n];

            for(int i=n-1;i>=0;i--){
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
                nse[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }
            stack = new Stack();
            int[] pse = new int[n];
            for(int i=0;i<n;i++){
                while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
                pse[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            int maxArea = 0;
            for(int i=0;i<n;i++) maxArea = Math.max(maxArea, (nse[i]-pse[i]-1)*heights[i] );
            return maxArea;
        }
    }
}
