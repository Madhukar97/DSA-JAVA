package com.codestudio.backtracking;

import java.util.*;

//Rat In a Maze
//https://www.codingninjas.com/studio/problems/rat-in-a-maze-_8842357?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze {
    public static List<String> ratMaze(int [][]mat) {
        int n=mat.length;
        boolean[][] dp = new boolean[n][n];
        ArrayList<String> ans = new ArrayList<>();
        recFunc(mat, 0, 0, dp, "", ans);
        return ans;
    }

    public static void recFunc(int[][] m, int i, int j, boolean[][] dp, String path, ArrayList<String> ans){
        if(i<0 || j<0 || i==m.length || j==m.length || m[i][j]==0 || dp[i][j]) return;

        if(i==m.length-1 && j==m.length-1 && m[i][j] == 1){
            ans.add(path);
            return;
        }

        dp[i][j] = true;
        //UP
        recFunc(m, i-1, j, dp, path+"U", ans);
        //DOWN
        recFunc(m, i+1, j, dp, path+"D", ans);
        //LEFT
        recFunc(m, i, j-1, dp, path+"L", ans);
        //RIGHT
        recFunc(m, i, j+1, dp, path+"R", ans);
        dp[i][j] = false;
    }
}
