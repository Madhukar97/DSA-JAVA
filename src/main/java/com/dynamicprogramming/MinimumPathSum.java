package com.dynamicprogramming;

//64. Minimum Path Sum
//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int ans = minPathSum(grid);
        System.out.println(ans);
    }
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = recFunc(grid, 0, 0, dp, vis);
        return ans;
    }

    static int recFunc(int[][] grid, int r, int c, int[][] dp, boolean[][] vis) {
        if(r == grid.length-1 && c == grid[0].length -1) return grid[r][c];

        if(vis[r][c] == true) return dp[r][c];

        int down = -1;
        int right = -1;
        int sum = 0;
        if(r < grid.length-1) down = recFunc(grid, r+1, c, dp, vis);
        if(c < grid[0].length-1) right = recFunc(grid, r, c+1, dp, vis);

        if(down == -1 && right != -1) sum = right;
        else if( right == -1 && down != -1) sum = down;
        else sum = Math.min(down, right);

        vis[r][c] = true;
        dp[r][c] = sum + grid[r][c];

        return dp[r][c];
    }
}
