package com.recursion.backtracking;

import java.util.*;

// Rat In A Maze
//https://www.naukri.com/code360/problems/rat-in-a-maze_1215030?leftPanelTabValue=PROBLEM
public class RatInAMaze {
    public class Solution {
        public static ArrayList< String > findSum(int[][] arr, int n) {
            // Write your code here.
            ArrayList < String > ans = new ArrayList<>();
            int[][] vis = new int[n][n];
            bfs(0, 0, arr, n, ans, "", vis);
            Collections.sort(ans);
            return ans;
        }

        private static void bfs(int x, int y, int[][] arr, int n, ArrayList < String > ans, String path, int[][] vis){
            if(x==n-1 && y==n-1) {
                ans.add(path);
                return;
            }
            if(x<0 || y<0 || x==n || y==n || arr[x][y] == 0 || vis[x][y] == 1) return;

            vis[x][y]=1;

            int[] rows = {-1,0,1,0};
            char[] dirs = {'U','R','D','L'};

            for(int c=0;c<4;c++){
                int newX = x + rows[c];
                int newY = y + rows[(c+1)%4];
                bfs(newX, newY, arr, n, ans, path+dirs[c], vis);
            }
            vis[x][y]=0;
        }
    }
}
