package com.dsa.backtracking;

// Find all the possible combinations of placing N queens in a given matrix without queens not cancelling each other
public class NQueens {
    public static void main(String[] args) {
        boolean[][] maze = new boolean[4][4];
        System.out.println(allCombinations(maze, 0));

    }

    static int allCombinations(boolean[][] maze, int row) {
        if ( row == maze.length ) {
            display(maze);
            System.out.println();
            return 1;
        }

        int count = 0;

        // placing the queen and checking for every row and col
        for (int col = 0; col < maze.length; col++) {
            // place the queen if its safe
            if(isSafe(maze, row, col)) {
                maze[row][col] = true;
                count+= allCombinations(maze, row+1);
                maze[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] maze, int row, int col) {
        // vertical direction check for queen
        for (int i = 0; i < row; i++) {
            if ( maze[i][col] ) return false;
        }

        // left diagonal check for queen
        int leftDiagonalLimit = Math.min(row, col);
        for (int i = 0; i <= leftDiagonalLimit ; i++) {
            if (maze[row-i][col-i]) return false;
        }

        // right diagonal check for queen
        int rightDiagonalLimit = Math.min(row, maze.length-col-1);
        for (int i = 0; i <= rightDiagonalLimit; i++) {
            if (maze[row-i][col+i]) return false;
        }
        return true;
    }

    private static void display(boolean[][] maze) {
        for( boolean[] arr : maze ) {
            for( boolean element : arr ) {
                if ( element ) System.out.print("Q ");
                else System.out.print("X ");
            }
            System.out.println();
        }
    }
}
