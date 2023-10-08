package com.striver.sde.sheet;

import java.util.ArrayList;
import java.util.List;

//73. Set Matrix Zeroes
//https://leetcode.com/problems/set-matrix-zeroes/description/
//https://takeuforward.org/data-structure/set-matrix-zero/
public class SetMatrixZeroes {
    //Better Approach with time complexity O(m*n) and space complexity O(m+n);
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //Most Optimized Approach with time complexity O(m*n) and space complexity O(1);
    public void setZeroesOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j == 0){
                        col0 = 0;
                    }else{
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j=0;j<n;j++){
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0){
            for(int i=0;i<m;i++) matrix[i][0] = 0;
        }
    }
}
