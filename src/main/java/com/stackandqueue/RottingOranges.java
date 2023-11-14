package com.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

//994. Rotting Oranges
//https://leetcode.com/problems/rotting-oranges/description/
public class RottingOranges {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);   //adds new element at end of queue
        queue.remove(); //removes head of queue
        queue.size();
        queue.peek();   //retrieves head of queue
        queue.poll();   //removes head of queue without exception
        queue.isEmpty();
    }
    //BFS solution using Queue
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis = new int[m][n];

        int freshCount=0;

        Queue<Orange> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    queue.add(new Orange(i,j,0));
                    vis[i][j]=2;
                }else if(grid[i][j] == 1) freshCount++;
            }
        }

        int t=0;
        while(!queue.isEmpty()){
            Orange curr = queue.poll();
            int[] rows=new int[]{-1,0,1,0};
            int[] cols=new int[]{0,1,0,-1};
            for(int i=0;i<4;i++){
                int crow=curr.r+rows[i];
                int ccol=curr.c+cols[i];
                if(crow>=0 && crow<m && ccol>=0 && ccol<n && grid[crow][ccol] == 1 && vis[crow][ccol] != 2){
                    vis[crow][ccol]=2;
                    queue.add(new Orange(crow,ccol,curr.t+1));
                    freshCount--;
                    t=Math.max(t, curr.t+1);
                }
            }
        }
        if(freshCount > 0) return -1;
        return t;
    }

    class Orange{
        int r;
        int c;
        int t;

        public Orange(int r, int c, int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    //Most Optimal sol by me using BFS and Queue with TC = O(m*n) and SC = O(1)
    class Solution {
        public int orangesRotting(int[][] grid) {
            int ans=0;
            int freshCount=0;
            int rottCount=0;
            int m=grid.length;
            int n=grid[0].length;
            Queue<Orange> q = new LinkedList<>();

            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(grid[i][j] == 2) {
                        q.add(new Orange(i,j));
                    }else if(grid[i][j] == 1) freshCount++;
                }
            }
            q.add(null);

            while(!q.isEmpty()){
                Orange curr = q.poll();

                if(curr == null && q.isEmpty()) break;
                else if(curr == null) {
                    ans++;
                    q.add(null);
                    continue;
                }
                //bfs
                int[] rows = {-1,0,1,0};
                int[] cols = {0,1,0,-1};
                for(int i=0;i<4;i++){
                    int newR = curr.x+rows[i];
                    int newC = curr.y+cols[i];
                    if(newR>=0 && newR<m && newC>=0 && newC<n && grid[newR][newC] == 1){
                        grid[newR][newC] = 2;
                        q.add(new Orange(newR,newC));
                        rottCount++;
                    }
                }

            }
            // System.out.println("RC : " + rottCount + ", FC : " +  freshCount);
            if(rottCount == freshCount) return ans;
            return -1;
        }

        public class Orange{
            int x;
            int y;

            public Orange(int x, int y){
                this.x=x;
                this.y=y;
            }
        }
    }
}
