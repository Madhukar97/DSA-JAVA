package com.graphs;

import java.util.*;

//Floyd Warshall
//https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
public class FloydWarshall {
    public void shortest_distance(int[][] matrix)
    {
        int n = matrix.length;

        //replace no edges (-1) to infinity and self to 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
                // if(i == j) matrix[i][j] = 0;
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                }
            }
        }

        //replace back no edges to -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) matrix[i][j] = -1;
            }
        }
    }

    //Coding ninjas
    //https://www.codingninjas.com/studio/problems/2041979?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
    static int floydWarshall(int n, int m, int src, int dest, ArrayList<ArrayList<Integer>> edges) {
        int[][] matrix = new int[n][n];

        for(int[] row : matrix) Arrays.fill(row, (int)1e9);

        for(List<Integer> edge : edges){
            int x =edge.get(0);
            int y =edge.get(1);
            int wt = edge.get(2);
            matrix[x-1][y-1] = wt;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) matrix[i][j]=0;
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][k] == 1e9 || matrix[k][j] == 1e9) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        return matrix[src-1][dest-1];
    }
}
