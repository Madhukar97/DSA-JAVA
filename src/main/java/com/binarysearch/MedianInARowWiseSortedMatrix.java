package com.binarysearch;

//Median in a row-wise sorted Matrix
//https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
public class MedianInARowWiseSortedMatrix {
    //Optimal sol using binary search
    public static int findMedian(int matrix[][], int m, int n) {
        int min=Integer.MAX_VALUE;
        int max=0;

        for(int i=0;i<m;i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][n-1]);
        }

        int ans=0;
        while(min <= max){
            int mid = min+(max-min)/2;
            int count = blackbox(matrix, mid);
            // System.out.println("min : " + min + ", max : " + max);
            // System.out.println("MID : " + mid + ", count : " + count);
            if(count <= m*n/2) min=mid+1;
            else max=mid-1;
        }
        return min;
    }

    public static int blackbox(int[][] matrix, int target){
        int count=0;

        for(int[] row : matrix){
            int s=0;
            int e=matrix[0].length-1;
            while(s <= e){
                int mid = s+(e-s)/2;
                if(row[mid] <= target) s=mid+1;
                else e=mid-1;
            }
            count+=s;
        }
        return count;
    }
}
