package com.graphs;

//130. Surrounded Regions
//https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
    //Sol Using DFS and vis[][] matrix
    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];

        for(int j=0;j<board[0].length;j++){
            if(vis[0][j]==0 && board[0][j] == 'O') dfs(board,vis,0,j);
            if(vis[board.length-1][j]==0 && board[board.length-1][j] == 'O') dfs(board,vis,board.length-1,j);
        }
        for(int i=0;i<board.length;i++){
            if(vis[i][0]==0 && board[i][0] == 'O') dfs(board,vis,i,0);
            if(vis[i][board[0].length-1]==0 && board[i][board[0].length-1] == 'O') dfs(board,vis,i,board[0].length-1);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(vis[i][j]==0) board[i][j]='X';
            }
        }

    }

    public void dfs(char[][] board, int[][] vis, int i, int j){
        if(vis[i][j]==1) return;
        vis[i][j] = 1;

        if(i-1 >=0 && board[i-1][j] == 'O') dfs(board,vis,i-1,j);
        if(j+1 < board[0].length && board[i][j+1] == 'O') dfs(board,vis,i,j+1);
        if(i+1 < board.length && board[i+1][j] == 'O') dfs(board,vis,i+1,j);
        if(j-1 >=0 && board[i][j-1] == 'O') dfs(board,vis,i,j-1);
    }
}
