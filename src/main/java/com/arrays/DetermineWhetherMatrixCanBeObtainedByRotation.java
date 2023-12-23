package com.arrays;

import java.util.Arrays;

//1886. Determine Whether Matrix Can Be Obtained By Rotation
//https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/
public class DetermineWhetherMatrixCanBeObtainedByRotation {
    //Rotate by 90 degrees = Transpose the matrix and reverse the rows
    class Solution {
        public boolean findRotation(int[][] matrix, int[][] target) {
            int n = matrix.length;
            for(int c=0;c<=3;c++){
                if(Arrays.deepToString(matrix).equals(Arrays.deepToString(target))) return true;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(i<j){
                            int temp = matrix[i][j];
                            matrix[i][j] = matrix[j][i];
                            matrix[j][i] = temp;
                        }
                    }
                }

                for(int[] row : matrix){
                    for(int j=0;j<n/2;j++){
                        int temp=row[j];
                        row[j]=row[n-j-1];
                        row[n-j-1]=temp;
                    }
                }
            }
            return false;
        }
    }
}
