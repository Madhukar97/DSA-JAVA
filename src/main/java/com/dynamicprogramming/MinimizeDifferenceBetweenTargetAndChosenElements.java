package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/description/
//1981. Minimize the Difference Between Target and Chosen Elements
public class MinimizeDifferenceBetweenTargetAndChosenElements {
    public static void main(String[] args) {

    }

    public int minimizeTheDifference(int[][] mat, int target) {
        int min = Integer.MAX_VALUE;
        if(mat.length ==1 ){
            for(int i : mat[0]){
                min = Math.min(min, Math.abs(i-target));
            }
        }

        boolean[][] dp =  new boolean[mat.length][(int)Math.pow(10,5)];

        List<Integer> anss = new ArrayList<Integer>();
        for(int col=0;col<mat[0].length;col++){
            rec(mat.length-1,col,mat,target,0,anss,dp);
        }

        for(int s : anss){
            min = Math.min(min, Math.abs(s-target));
        }
        return min;
    }

    //Recursion with Memoization(Top-Down approach) TC = O(i*target??) and SC = O(n) + dp[n][target??+1]
    public void rec(int i, int j, int[][] mat, int target, int sum, List<Integer> anss, boolean[][] dp){
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length) return ;
        if(i == 0){
            anss.add(sum+mat[i][j]);
            return ;
        }
        if(dp[i][sum+mat[i][j]] == true )return ;

        for(int col=0;col<mat[0].length;col++){
            rec(i-1,col,mat,target,sum+mat[i][j],anss,dp);
            dp[i][sum+mat[i][j]] = true;
        }
    }
}
