package com.dsa.backtracking;

//You can only move right and down in the matrix and find the no of possible paths to reach the final position
public class MazeDemo3x3Matrix {
    public static void main(String[] args) {
        System.out.println(noOfPaths(3,3));
        printAllPaths("", 3, 3);
    }

    //Method to print the no.of possible paths
    static int noOfPaths(int r, int c) {
        if ( r == 1 || c == 1 ) return 1;
        return noOfPaths(r-1, c) + noOfPaths(r, c-1);
    }

    //Method to print all the possible paths
    static void printAllPaths(String processed, int r, int c) {
        if ( r == 1 && c == 1 ) {
            System.out.println(processed);
            return;
        }
        if ( r > 1 ) printAllPaths(processed + "D", r-1, c);
        if ( c > 1 )  printAllPaths(processed + "R", r, c-1);
    }
}
