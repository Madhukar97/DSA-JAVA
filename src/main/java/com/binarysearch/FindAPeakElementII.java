package com.binarysearch;

//1901. Find a Peak Element II
//https://leetcode.com/problems/find-a-peak-element-ii/description/
public class FindAPeakElementII {
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int m=mat.length;
            int n=mat[0].length;
            int start=0;
            int end=n-1;
            while(start <= end){
                int mid = start + (end-start)/2;
                int maxRow = findMaxRow(mat, mid);
                int left = mid-1 <0 ? -1 : mat[maxRow][mid-1];
                int right = mid+1 ==n ? -1 : mat[maxRow][mid+1];
                if(left < mat[maxRow][mid] && right < mat[maxRow][mid]) return new int[]{maxRow, mid};
                else if(left > mat[maxRow][mid]) end=mid-1;
                else start=mid+1;
            }
            return new int[]{-1,-1};
        }

        public int findMaxRow(int[][] mat, int col){
            int row=0;
            int max=0;
            for(int i=0;i<mat.length;i++){
                if(mat[i][col] > max){
                    row=i;
                    max=mat[i][col];
                }
            }
            return row;
        }
    }
}
