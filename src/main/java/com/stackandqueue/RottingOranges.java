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
}
