package com.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

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

    //Slightly Optimal sol
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        recFunc(board, 0, 0, ans);
        return ans;
    }

    public void recFunc(int[][] board, int i, int j, List<List<String>> ans){
        if(i == board.length){
            // System.out.println("ANS : " + Arrays.deepToString(board));
            List<String> ans1 = new ArrayList<>();
            for(int[] row : board){
                String s = "";
                for(int q : row){
                    s+=q==1 ? "Q" : ".";
                }
                ans1.add(s);
            }
            ans.add(ans1);
            return;
        }

        for(int c=j;c<board.length;c++){
            if(validPosition(board, i, c)){
                board[i][c] = 1;
                recFunc(board, i+1, 0, ans);
                board[i][c] = 0;
            }
        }
    }

    public boolean validPosition(int[][] board, int i, int j){
        for(int r=i-1;r>=0;r--){
            if(board[r][j] == 1) return false;
        }
        int r=i;
        int c=j;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 1) return false;
            r--;
            c--;
        }
        r=i;
        c=j;
        while(r >=0 && c < board.length){
            if(board[r][c] == 1) return false;
            r--;
            c++;
        }
        return true;
    }
}
