package com.recursion.backtracking;

//37. Sudoku Solver
//https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public static void main(String[] args) {

    }
    static boolean flag = false;
    public static void solveSudoku(char[][] board) {
        flag=false;
        char[] arr = {'.','1','2','3','4','5','6','7','8','9'};
        sudokuSolver(board, 0, 0, arr);
    }

    static void sudokuSolver(char[][] sudoku, int r, int c, char[] arr) {
        if ( r > sudoku.length-1 ) {
            flag = true;
            return;
        }

        if (sudoku[r][c] != '.') {
            if ( c < sudoku[0].length - 1 ) {
                sudokuSolver(sudoku, r, c+1, arr);
            } else sudokuSolver(sudoku, r+1, 0, arr);
        }
        else {
            for (int i = 1; i <= 9; i++) {
                if ( isSafe(sudoku, r, c, arr[i]) ) {
                    sudoku[r][c] = arr[i];
                    if ( c < sudoku[0].length - 1 ) {
                        sudokuSolver(sudoku, r, c+1, arr);
                    } else sudokuSolver(sudoku, r+1, 0, arr);
                    if(!flag){
                        sudoku[r][c] = arr[0];
                    }
                }
            }
        }
    }

    private static boolean isSafe(char[][] sudoku, int r, int c, char num) {
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

    private static void display(char[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean checkIfFilled(char[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (sudoku[i][j] == '.') return false;
            }
        }
        return true;
    }
}
