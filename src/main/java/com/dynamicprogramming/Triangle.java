package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/triangle/
public class Triangle {

    public static void main(String[] args) {
        List<Integer> dp = new ArrayList<>();
        dp.sort(Integer::compareTo);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(List<Integer> tRow: triangle){
            List<Integer> row = new ArrayList<Integer>();
            for(int i : tRow){
                row.add(Integer.MAX_VALUE);
            }
            dp.add(row);
        }

        return rec(0,0,triangle,dp);
    }

    //Recursion with Memoization solution TC = O(i*j), SC = O(i) + dp[i][j]
    public int rec(int i, int j, List<List<Integer>> triangle, List<List<Integer>> dp){
        if(i == triangle.size()-1) return triangle.get(i).get(j);
        if(i >= triangle.size() || j >= triangle.get(i).size()) return Integer.MAX_VALUE;
        if(dp.get(i).get(j) != Integer.MAX_VALUE) return dp.get(i).get(j);

        int down=Integer.MAX_VALUE;
        int diag=Integer.MAX_VALUE;
        down = rec(i+1,j,triangle,dp);
        diag = rec(i+1,j+1,triangle,dp);

        int min = triangle.get(i).get(j) + Math.min(down,diag);
        dp.get(i).add(j, min);
        return min;
    }

    //Tabulation solution TC = O(i*j), SC = dp[i][j]
    public int minimumTotalTabulation(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(List<Integer> tRow: triangle){
            List<Integer> row = new ArrayList<Integer>();
            for(int i : tRow){
                row.add(Integer.MAX_VALUE);
            }
            dp.add(row);
        }

        for(int r=0;r<triangle.size();r++){
            for(int c=0;c<triangle.get(r).size();c++){
                if(r==0 && c==0) dp.get(0).add(0,triangle.get(r).get(c));
                else{
                    int down=Integer.MAX_VALUE;
                    int diag=Integer.MAX_VALUE;
                    if(r > 0) down = dp.get(r-1).get(c);
                    if(r > 0 && c > 0) diag = dp.get(r-1).get(c-1);

                    int min = triangle.get(r).get(c) + Math.min(down,diag);
                    dp.get(r).add(c, min);
                }
            }
        }
        int ans = dp.get(dp.size()-1).get(0);
        for(int i : dp.get(dp.size()-1)){
            if(i < ans) ans = i;
        }
        return ans;
    }

    //Tabulation wit spaceOptimization solution TC = O(i*j), SC = dp[j]
    public int minimumTotalSpaceOptimization(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(List<Integer> tRow: triangle){
            List<Integer> row = new ArrayList<Integer>();
            for(int i : tRow){
                row.add(Integer.MAX_VALUE);
            }
            dp.add(row);
        }

        List<Integer> prevRow = new ArrayList<Integer>();
        List<Integer> currRow = new ArrayList<Integer>();


        for(int r=0;r<triangle.size();r++){
            for(int c=0;c<triangle.get(r).size();c++){
                if(r==0 && c==0) currRow.add(0,triangle.get(r).get(c));
                else{
                    int down=Integer.MAX_VALUE;
                    int diag=Integer.MAX_VALUE;
                    if(c < prevRow.size() ) down = prevRow.get(c);
                    if(c > 0) diag = prevRow.get(c-1);

                    int min = triangle.get(r).get(c) + Math.min(down,diag);
                    currRow.add(c, min);
                }
            }
            prevRow = currRow;
            currRow = new ArrayList<Integer>();
        }
        int ans = prevRow.get(0);
        for(int i : prevRow){
            if(i < ans) ans = i;
        }
        return ans;
    }

}
