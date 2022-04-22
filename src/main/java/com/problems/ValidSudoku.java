package com.problems;

//36. Valid Sudoku
//https://leetcode.com/problems/valid-sudoku/
// amazon apple microsoft uber
public class ValidSudoku {
    static boolean recFunc(char[][] board) {
        boolean valid = true;
        for( int r=0; r < board.length; r++){
            for(int c=0; c < board.length; c++){
                if(board[r][c] != '.') {
                    valid = isValid(board, r, c, board[r][c]);
                    if(!valid) return false;
                }
            }
        }
        return true;
    }

    static boolean isValid(char[][] sudoku, int r, int c, char num) {
        int count = 0;
        for (int i = 0; i < sudoku.length; i++) {
            if ( sudoku[r][i] == num ) count++;
        }
        for (int i = 0; i < sudoku.length; i++) {
            if ( sudoku[i][c] == num ) count++;
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
                if ( sudoku[i][j] == num ) count++;
            }
        }
        if(count > 3) return false;
        return true;
    }
}
