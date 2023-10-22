package com.problems;

//463. Island Perimeter
//https://leetcode.com/problems/island-perimeter/description/
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int ans=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1)ans += calcPeri(grid, i, j);
            }
        }
        return ans;
    }

    public int calcPeri(int[][] grid, int i, int j){
        int count =0;

        if(i-1 >= 0 && grid[i-1][j]==1) count++;
        if(j+1 < grid[0].length && grid[i][j+1]==1) count++;
        if(i+1 < grid.length && grid[i+1][j] == 1)count++;
        if(j-1 >= 0 && grid[i][j-1] == 1) count++;
        // System.out.println("R:"+i+",C:"+j+", count = "+count);
        if(count == 4) return 0;
        else if (count ==3) return 1;
        else if (count ==2) return 2;
        else if(count ==1) return 3;
        return 4;
    }
}
