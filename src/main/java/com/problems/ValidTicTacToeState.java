package com.problems;

//794. Valid Tic-Tac-Toe State
//leetcode.com/problems/valid-tic-tac-toe-state/description/
public class ValidTicTacToeState {
    class Solution {
        public boolean validTicTacToe(String[] board) {
            int xCount=0;
            int oCount=0;

            for(String row : board){
                for(int i=0;i<row.length();i++){
                    char ch = row.charAt(i);
                    if(ch == 'X') xCount++;
                    else if(ch == 'O') oCount++;
                }
            }
            if(xCount-oCount <=1 && xCount-oCount >=0 && isValid(board, xCount, oCount)) return true;
            else return false;
        }

        public boolean isValid(String[] board, int xCount, int oCount){
            int validRows=0;
            char valid = ' ';
            for(String row : board){
                char ch = row.charAt(0);
                int count = 1;
                for(int i=1;i<3;i++){
                    if(ch == row.charAt(i) && ch != ' ') count++;
                }
                if(count == 3) {
                    validRows++;
                    valid = ch;
                }
            }

            int validCols = 0;
            for(int j=0;j<3;j++){
                char ch = board[0].charAt(j);
                int count = 1;
                for(int i=1;i<3;i++){
                    if(ch == board[i].charAt(j) && ch != ' ') count++;
                }
                if(count == 3){
                    validCols++;
                    valid = ch;
                }
            }
            char ch = board[0].charAt(0);
            int count = 1;
            if(ch == board[1].charAt(1)  && ch != ' ') count++;
            if(ch == board[2].charAt(2)  && ch != ' ') count++;
            if(count == 3){
                valid = ch;
            }
            ch = board[0].charAt(2);
            count = 1;
            if(ch == board[1].charAt(1)  && ch != ' ') count++;
            if(ch == board[2].charAt(0)  && ch != ' ') count++;
            if(count == 3){
                valid = ch;
            }
            if(valid == 'X' && oCount >= xCount || valid == 'O' && oCount < xCount) return false;
            if(validCols >1 || validRows > 1 ) return false;
            return true;
        }
    }
}
