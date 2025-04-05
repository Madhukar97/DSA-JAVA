package com.stackandqueue;

import java.util.Stack;

//221. Maximal Square
//https://leetcode.com/problems/maximal-square/description/
public class MaximalSquare {
    class Solution {
        public int maximalSquare(char[][] matrix) {
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
            for(int i=0;i<n;i++) {
                int minDimension = Math.min(nse[i]-pse[i]-1,heights[i]);
                maxArea = Math.max(maxArea, minDimension*minDimension );
            }
            return maxArea;
        }
    }

    // Dp solution
    class Solution2 {
        public int maximalSquare(char[][] matrix) {
            int r=matrix.length;
            int c=matrix[0].length;
            int[][] dp = new int[r+1][c+1];
            int maxDimension=0;
            for(int i=1;i<=r;i++){
                for(int j=1;j<=c;j++){
                    if(matrix[i-1][j-1] == '1'){
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
                        maxDimension = Math.max(maxDimension, dp[i][j]);
                    }
                }
            }
            return maxDimension*maxDimension;
        }
    }
}
