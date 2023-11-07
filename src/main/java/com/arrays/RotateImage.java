package com.arrays;

//48. Rotate Image
//https://leetcode.com/problems/rotate-image/description/
public class RotateImage {
    //Optimal Sol without extra space and TC = O(n*n) and SC = O(1)
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0;i<n-1;i++){
            for(int j=1;j<n;j++){
                if(i > j) continue;
                swap(i,j,j,i,matrix);
            }
        }

        for(int[] row : matrix){
            reverse(row);
        }
    }

    public void swap(int i1, int j1, int i2, int j2, int[][] matrix){
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public void reverse(int[] arr){
        int p1=0;
        int p2=arr.length-1;
        while(p1  < p2){
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }

    //Revision 2 sol
    public void rotateR2(int[][] matrix) {
        int n = matrix.length;

        for(int i=0;i<n-1;i++){
            for(int j=1;j<n;j++){
                if(j > i){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        for(int[] row : matrix){
            for(int j=0;j<n/2;j++){
                int temp = row[j];
                row[j] = row[n-j-1];
                row[n-j-1] = temp;
            }
        }
    }
}
