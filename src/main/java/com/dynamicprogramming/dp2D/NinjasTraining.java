package com.dynamicprogramming.dp2D;

//Ninja’s Training
//https://www.naukri.com/code360/problems/ninja-s-training_3621003?leftPanelTabValue=PROBLEM
public class NinjasTraining {
    // Memoization sol
    public class Solution {
        public static int ninjaTraining(int n, int points[][]) {
            int max=0;
            for(int j=0;j<3;j++) {
                Integer[][] maxP = new Integer[n][3];
                max = Math.max(max, findMaxPoints(n-1,j, points, maxP));
            }
            return max;
        }

        private static int findMaxPoints(int index, int j, int[][] points, Integer[][] maxP){
            if(index == 0) return points[index][j];
            if(maxP[index][j] != null) return maxP[index][j];

            int max = 0;
            for(int col=0;col<3;col++){
                if(col != j) max = Math.max(max, findMaxPoints(index-1,col, points, maxP));
            }
            return maxP[index][j] = max + points[index][j];
        }
    }
    // Tabulation sol
    public static int tabulation(int n, int[][] points){
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
    // Space optimization
    public static int tabulationWithSpaceOptimization(int n, int[][] points){
        int[] dp = new int[4];
        int[] currDay = new int[4];

        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day<n; day++){
            for(int last=0; last<4; last++){

                int maxP=0;
                for(int task=0; task<3; task++){
                    if(task != last){
                        maxP = Math.max(maxP, points[day][task] + dp[task]);

                    }
                }
                currDay[last] = maxP;
            }
            dp = currDay;
            currDay = new int[4];
        }
        return dp[3];

    }
}
