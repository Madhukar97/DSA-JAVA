package com.dsa.backtracking;

//You can only move right and down in the matrix and find the no of possible paths to reach the final position
public class MazeDemo3x3Matrix {
    public static void main(String[] args) {
        System.out.println(noOfPaths(3,3));
    }

    static int noOfPaths(int r, int c) {
        if ( r == 1 || c == 1 ) return 1;
        return noOfPaths(r-1, c) + noOfPaths(r, c-1);
    }
}
