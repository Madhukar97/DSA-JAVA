package com.dsa.backtracking;

import java.util.Arrays;

// Sudoku solver using backtracking in recursion
public class SudokuSolver {
    public static void main(String[] args) {
        int[][] sudoku = {  {3, 0, 6, 5, 0, 8, 4, 0, 0},
                            {5, 2, 0, 0, 0, 0, 0, 0, 0},
                            {0, 8, 7, 0, 0, 0, 0, 3, 1},
                            {0, 0, 3, 0, 1, 0, 0, 8, 0},
                            {9, 0, 0, 8, 6, 3, 0, 0, 5},
                            {0, 5, 0, 0, 9, 0, 6, 0, 0},
                            {1, 3, 0, 0, 0, 0, 2, 5, 0},
                            {0, 0, 0, 0, 0, 0, 0, 7, 4},
                            {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        sudokuSolver(sudoku, 0, 0);
    }
    static void sudokuSolver(int[][] sudoku, int r, int c) {
        if ( checkIfFilled(sudoku) ) {
            display(sudoku);
            System.out.println("Sudoku solved!!");
            return;
        }

        if (sudoku[r][c] != 0) {
            if ( c < sudoku[0].length - 1 ) {
                sudokuSolver(sudoku, r, c+1);
            } else sudokuSolver(sudoku, r+1, 0);
        }
        else {
            for (int i = 1; i <= 9; i++) {
                if ( isSafe(sudoku, r, c, i) ) {
                    sudoku[r][c] = i;
                    if ( c < sudoku[0].length - 1 ) {
                        sudokuSolver(sudoku, r, c+1);
                    } else sudokuSolver(sudoku, r+1, 0);
                    sudoku[r][c] = 0;
                }
            }
        }
    }

    private static boolean isSafe(int[][] sudoku, int r, int c, int num) {
        for (int i = 0; i < sudoku.length; i++) {
            if ( sudoku[r][i] == num ) return false;
        }
        for (int i = 0; i < sudoku.length; i++) {
            if ( sudoku[i][c] == num ) return false;
        }

        int rMin = 0;
        int rMax = 0;
        int cMin = 0;
        int cMax = 0;

        if (r>=0 && r<=2 ) {
            rMin = 0;
            rMax = 2;
            if (c>=0 && c<=2 ) {
                cMin = 0;
                cMax = 2;
            }
            if (c>=3 && c<=5 ) {
                cMin = 3;
                cMax = 5;
            }
            if (c>=6 && c<=8 ) {
                cMin = 6;
                cMax = 8;
            }
        }
        if (r>=3 && r<=5 ) {
            rMin = 3;
            rMax = 5;
            if (c>=0 && c<=2 ) {
                cMin = 0;
                cMax = 2;
            }
            if (c>=3 && c<=5 ) {
                cMin = 3;
                cMax = 5;
            }
            if (c>=6 && c<=8 ) {
                cMin = 6;
                cMax = 8;
            }
        }
        if (r>=6 && r<=8 ) {
            rMin = 6;
            rMax = 8;
            if (c>=0 && c<=2 ) {
                cMin = 0;
                cMax = 2;
            }
            if (c>=3 && c<=5 ) {
                cMin = 3;
                cMax = 5;
            }
            if (c>=6 && c<=8 ) {
                cMin = 6;
                cMax = 8;
            }
        }

        for (int i = rMin; i <= rMax; i++) {
            for (int j = cMin; j <= cMax; j++) {
                if ( sudoku[i][j] == num ) return false;
            }
        }
        return true;
    }

    private static void display(int[][] sudoku) {
        for( int[] row : sudoku ) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static boolean checkIfFilled(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == 0) return false;
            }
        }
        return true;
    }
}
