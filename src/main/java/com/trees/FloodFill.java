package com.trees;

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
}
