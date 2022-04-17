package com.dsa.backtracking;

import java.util.Arrays;

// Print the path and steps in Matrix with backtracking using recursion from Pt. A to Pt. B
public class PrintMatrixAndPath {
    public static void main(String[] args) {
        boolean[][] maze = {{true,true,true},{true,true,true},{true,true,true}};
        printAllPaths("", maze, 0, 0, new int[maze.length][maze[0].length], 1);
    }

    static void printAllPaths(String path, boolean[][] maze, int r, int c, int[][] ans, int step) {
        if ( r == maze.length-1 && c == maze[0].length-1 ) {
            ans[r][c] = step;
            System.out.println(path);
            for(int[] arr : ans) System.out.println(Arrays.toString(arr));
            System.out.println();
            return;
        }

        if ( !maze[r][c] ) return;

        maze[r][c] = false;
        ans[r][c] = step;
        if ( r < maze.length-1 ) printAllPaths(path + "D", maze, r+1, c, ans, step+1);
        if ( c < maze[0].length-1 ) printAllPaths(path + "R", maze, r, c+1, ans, step+1);
        if ( r > 0 ) printAllPaths(path + "U", maze, r-1, c, ans, step+1);
        if ( c > 0 ) printAllPaths(path + "L", maze, r, c-1, ans, step+1);

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that are made
        maze[r][c] = true;
        ans[r][c] = 0;
    }
}
