package com.graphs;

import java.util.*;

//Shortest Distance in a Binary Maze
//https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze
public class ShortestDistanceInABinaryMaze {
    //Using BFS and Queue
    class Solution {

        int shortestPath(int[][] grid, int[] source, int[] destination) {

            int n=grid.length;
            int m=grid[0].length;
            if(grid[destination[0]][destination[1]]==0) return -1;

            int[][] vis = new int[n][m];
            grid[source[0]][source[1]] = 1;

            Queue<int[]> q = new LinkedList<>();
            q.add(source);

            int[] rows = {0,0,1,-1};
            int[] cols = {1,-1,0,0};
            int count=0;

            while(!q.isEmpty()){
                int size = q.size();

                for(int i=0;i<size;i++){
                    int[] curr = q.poll();
                    int x = curr[0];
                    int y = curr[1];
                    if(x==destination[0] && y==destination[1]) return count;

                    for(int j=0;j<4;j++){
                        int newX = x + rows[j];
                        int newY = y + cols[j];
                        if(newX >=0 && newY >=0 && newX<n && newY<m && grid[newX][newY]==1 && vis[newX][newY]==0){
                            q.add(new int[]{newX,newY});
                            vis[newX][newY] = 1;
                        }
                    }
                }
                count++;
            }
            return -1;
        }
    }

}
