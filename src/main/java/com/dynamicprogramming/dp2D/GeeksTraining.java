package com.dynamicprogramming.dp2D;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/geeks-training/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=geeks-training
public class GeeksTraining {

    // Brute Force using recursion giving TLE
    class Solution {
        public int maximumPoints(int arr[][]) {
            int m = arr.length;
            int n = arr[0].length;
            int max = 0;
            for(int i=0;i<3;i++) max = Math.max(max, rec(m-1,i,arr));
            return max;
        }

        int rec(int i, int j, int[][] arr){
            if(i < 0 || j < 0 || i==arr.length || j==arr[0].length) return 0;

            int max = 0;
            for(int k=0;k<3;k++) {
                if(k == j) continue;
                max = Math.max(max, rec(i-1, k, arr));
            }
            return arr[i][j] + max;
        }
    }

    // Memoization
    class Solution2 {
        public int maximumPoints(int arr[][]) {
            int m = arr.length;
            int n = arr[0].length;
            int[][] maxPoints = new int[m][3];
            for(int[] row : maxPoints) Arrays.fill(row, -1);

            int max = 0;
            for(int i=0;i<3;i++) max = Math.max(max, rec(m-1,i,arr, maxPoints));
            return max;
        }

        int rec(int i, int j, int[][] arr, int[][] maxPoints){
            if(i < 0 || j < 0 || i==arr.length || j==arr[0].length) return 0;

            if(maxPoints[i][j] != -1) return maxPoints[i][j];

            int max = 0;
            for(int k=0;k<3;k++) {
                if(k == j) continue;
                max = Math.max(max, rec(i-1, k, arr, maxPoints));
            }
            return maxPoints[i][j] = arr[i][j] + max;
        }
    }

    // Tabulation
    class Solution3 {
        public int maximumPoints(int arr[][]) {
            int m = arr.length;
            int n = arr[0].length;
            int[][] maxPoints = new int[m][3];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int max = 0;
                    for (int k = 0; k < 3; k++) {
                        if (k == j) continue;
                        if (i - 1 >= 0) max = Math.max(max, maxPoints[i - 1][k]);
                    }
                    maxPoints[i][j] = arr[i][j] + max;
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) ans = Math.max(ans, maxPoints[m - 1][i]);
            return ans;
        }
    }

    // Space Optimization
    class Solution4 {
        public int maximumPoints(int arr[][]) {
            int m = arr.length;
            int n = arr[0].length;
            int[] prevRow = new int[3];
            int[] currRow = new int[3];
            // for(int[] row : maxPoints) Arrays.fill(row, -1);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int max = 0;
                    for (int k = 0; k < 3; k++) {
                        if (k == j) continue;
                        if (i - 1 >= 0) max = Math.max(max, prevRow[k]);
                    }
                    currRow[j] = arr[i][j] + max;
                }
                prevRow = currRow;
                currRow = new int[3];
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, prevRow[i]);
            }
            return ans;
        }
    }
}
