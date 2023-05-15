package com.codestudio.dynamicprogramming;

//https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?leftPanelTab=0
//3D - Dynamic programming problem
public class ChocolatePickup {
    public static void main(String[] args) {

    }

    public static int maximumChocolates(int r, int c, int[][] grid) {
        return rec(0,0,c-1,grid);
    }

    //Normal recursion solution with TC = O(3^(i*j)) and SC = O(i-1+j-1)
    //getting TLE
    public static int rec(int i, int j1, int j2, int[][] grid){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length) return -1;
        if(i==grid.length-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int max=0;
        for(int c1=-1;c1<2;c1++){
            for(int c2=-1;c2<2;c2++){
                int sum = rec(i+1,j1+c1,j2+c2,grid);
                if(j1 == j2) sum+= grid[i][j1];
                else sum+= grid[i][j1] + grid[i][j2];
                if(max < sum) max = sum;
            }
        }
        return max;
    }

    public static int maximumChocolatesDP(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                for(int k=0;k<c;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return recDP(0,0,c-1,grid,dp);
    }

    //Recursion with Memoization(Top-Down approach) solution TC = O(i*j*j) , SC = O(i) + dp[r][c][c]
    public static int recDP(int i, int j1, int j2, int[][] grid, int[][][] dp){
        if(j1<0 || j1>=grid[0].length || j2<0 || j2>=grid[0].length) return -1;
        if(i==grid.length-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max=0;
        for(int c1=-1;c1<2;c1++){
            for(int c2=-1;c2<2;c2++){
                int sum = recDP(i+1,j1+c1,j2+c2,grid,dp);
                if(j1 == j2) sum+= grid[i][j1];
                else sum+= grid[i][j1] + grid[i][j2];
                if(max < sum) max = sum;
            }
        }
        dp[i][j1][j2] = max;
        return max;
    }

    /*Bottom-up or Top-down doesn't indicate direction of solving but indicate way of solving either from base-case(Bottom-up) or
     from end-state to base-case(Top-down)*/
    //Tabulation(Bottom-up approach) solution TC = O(i*j*j) , SC = dp[r][c][c]
    public static int maximumChocolatesTabulation(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for(int j1=0;j1<c;j1++){
            for(int j2=0;j2<c;j2++){
                if(j1==j2) dp[r-1][j1][j2] = grid[r-1][j1];
                else dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }

        for(int i=r-2;i>=0;i--){
            for(int j1=0;j1<c;j1++){
                for(int j2=0;j2<c;j2++){
                    int max=0;

                    for(int p1=-1;p1<2;p1++){
                        for(int p2=-1;p2<2;p2++){
                            int sum = Integer.MIN_VALUE;
                            if(j1+p1 >= 0 && j1+p1 < c && j2+p2 >= 0 && j2+p2 < c)
                                sum = dp[i+1][j1+p1][j2+p2];
                            if(j1 == j2) sum+= grid[i][j1];
                            else sum+= grid[i][j1] + grid[i][j2];
                            if(max < sum) max = sum;
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][c-1];
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(i*j*j) , SC = dp[c][c]
    public static int maximumChocolatesTabulationSpaceOptimization(int r, int c, int[][] grid) {
        int[][] nextRow = new int[c][c];
        int[][] currRow = new int[c][c];

        for(int j1=0;j1<c;j1++){
            for(int j2=0;j2<c;j2++){
                if(j1==j2) nextRow[j1][j2] = grid[r-1][j1];
                else nextRow[j1][j2] = grid[r-1][j1] + grid[r-1][j2];
            }
        }

        for(int i=r-2;i>=0;i--){
            for(int j1=0;j1<c;j1++){
                for(int j2=0;j2<c;j2++){
                    int max=0;

                    for(int p1=-1;p1<2;p1++){
                        for(int p2=-1;p2<2;p2++){
                            int sum = Integer.MIN_VALUE;
                            if(j1+p1 >= 0 && j1+p1 < c && j2+p2 >= 0 && j2+p2 < c)
                                sum = nextRow[j1+p1][j2+p2];
                            if(j1 == j2) sum+= grid[i][j1];
                            else sum+= grid[i][j1] + grid[i][j2];
                            if(max < sum) max = sum;
                        }
                    }
                    currRow[j1][j2] = max;
                }
            }
            nextRow = currRow;
            currRow = new int[c][c];
        }
        return nextRow[0][c-1];
    }
}
