package com.codestudio.dynamicprogramming;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?leftPanelTab=1
public class NinjaTraining {
    public static void main(String[] args) {
        int[][] points1 = new int[][]{{1,2,5},{3,1,1},{3,3,3}};
        System.out.println("MAX points :: "+ninjaTraining(3,points1));
        System.out.println("MAX points :: "+tabulationSolution(3,points1));
    }


    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        System.out.println("DP::::"+Arrays.deepToString(dp));
        return trainRecursionMemoizationSolution(n-1,3, points, dp);
    }

    // giving stack over flow error for Memoization in java, same logic working in c++
    public static int trainRecursionMemoizationSolution(int day, int last, int points[][], int dp[][]) {
        if(day == 0) {
            int maxTask = 0;
            for(int i=0; i<3; i++){
                if(i != last)maxTask = Math.max(maxTask, points[0][i]);
            }
            return maxTask;
        }

        if(dp[day][last] != 0) return dp[day][last];
        int maxP = 0;

        for(int i=0; i<3; i++){
            if(i != last) {
                maxP = Math.max(maxP,points[day][i] + trainRecursionMemoizationSolution(day-1, i, points, dp));
            }
        }

        dp[day][last] = maxP;
        return maxP;
    }

    public static int tabulationSolution(int n, int[][] points){
        int dp[][] = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day<n; day++){
            for(int last=0; last<4; last++){

                int maxP=0;
                for(int task=0; task<3; task++){
                    if(task != last){
                        maxP = Math.max(maxP, points[day][task] + dp[day-1][task]);

                    }
                }
                dp[day][last] = maxP;
            }
        }
        return dp[n-1][3];

    }


}
