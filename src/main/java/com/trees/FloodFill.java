package com.trees;

import java.util.*;

//733. Flood Fill
//https://leetcode.com/problems/flood-fill/description/
public class FloodFill {
    //Sol using DFS and recursion
    //can also be solved using BFS with iteration and Queue
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if(originalColor == color) return image;

        dfs(image, sr, sc, originalColor, color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int originalColor, int color){
        if(sr < 0 || sc < 0 || sr == image.length || sc == image[0].length || image[sr][sc] != originalColor || image[sr][sc] == color) return;

        image[sr][sc] = color;

        dfs(image, sr-1, sc, originalColor, color);
        dfs(image, sr, sc+1, originalColor, color);
        dfs(image, sr+1, sc, originalColor, color);
        dfs(image, sr, sc-1, originalColor, color);
    }

    //Revision 2
    //Using BFS
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if(image[sr][sc] == color) return image;
            int original = image[sr][sc];
            int m=image.length;
            int n=image[0].length;
            Queue<Cell> q = new LinkedList<>();
            q.add(new Cell(sr,sc,original));

            while(!q.isEmpty()){
                Cell cell = q.poll();
                image[cell.x][cell.y] = color;

                int[] rows = {-1,0,1,0};
                int[] cols = {0,1,0,-1};
                for(int i=0;i<4;i++){
                    int newX = cell.x + rows[i];
                    int newY = cell.y + cols[i];
                    if(newX >=0 && newX < m && newY >=0 && newY < n && image[newX][newY] == original){
                        image[newX][newY] = color;
                        q.add(new Cell(newX,newY,color));
                    }
                }
            }
            return image;
        }

        public class Cell{
            int x;
            int y;
            int col;

            public Cell(int x, int y, int c){
                this.x=x;
                this.y=y;
                col=c;
            }
        }
    }
}
