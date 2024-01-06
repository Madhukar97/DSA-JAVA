package com.graphs;

import java.util.*;

//1631. Path With Minimum Effort
//https://leetcode.com/problems/path-with-minimum-effort/description/
public class PathWithMinimumEffort {
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int m=heights.length;
            int n=heights[0].length;

            int[][] dist = new int[m][n];
            for(int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
            dist[0][0]=0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)->a1[2]-a2[2]); //arr : {i,j,wt}
            pq.add(new int[]{0,0,0});

            int[] rows = {-1,0,1,0};
            int[] cols = {0,1,0,-1};

            while(!pq.isEmpty()){
                int[] edge = pq.poll();
                int i = edge[0];
                int j = edge[1];
                int prevDist = edge[2];

                if(i==m-1 && j==n-1) return prevDist;

                for(int k=0;k<4;k++){
                    int x = i+rows[k];
                    int y = j+cols[k];
                    if(x>=0 && x<m && y>=0 && y<n){
                        int absDiff = Math.abs(heights[i][j]-heights[x][y]);
                        int maxDiff = Math.max(absDiff, prevDist);
                        if(maxDiff < dist[x][y]){
                            dist[x][y] = maxDiff;
                            pq.add(new int[]{x,y,maxDiff});
                        }
                    }
                }
            }
            return 0;
        }
    }
}
