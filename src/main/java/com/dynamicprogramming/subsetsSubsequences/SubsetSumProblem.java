package com.dynamicprogramming.subsetsSubsequences;

//https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
public class SubsetSumProblem {

    // Brute force using recursion
    class Solution {

        static Boolean isSubsetSum(int arr[], int target) {
            int n=arr.length;
            int sum=0;
            for(int i : arr) sum+=i;

            return findTarget(n-1, arr, target);
        }

        static boolean findTarget(int i, int[] arr, int target){
            if(i < 0 || target<0) return false;
            if(arr[i] == target) return true;

            return findTarget(i-1, arr, target-arr[i]) || findTarget(i-1, arr, target);
        }
    }

    // Memoization
    class Solution2 {

        static Boolean isSubsetSum(int arr[], int target) {
            int n=arr.length;
            int sum=0;
            for(int i : arr) sum+=i;

            int[][] targets = new int[n][target+1];
            for(int[] row : targets) {
                for(int i=0;i<row.length;i++) row[i] = -1;
            }

            return findTarget(n-1, arr, target, targets);
        }

        static boolean findTarget(int i, int[] arr, int target, int[][] targets){
            if(i < 0 || target<0) return false;
            if(arr[i] == target) return true;
            if(targets[i][target] != -1) return targets[i][target] == 1;

            //pick or notPick
            return (targets[i][target] = findTarget(i-1, arr, target-arr[i], targets) || findTarget(i-1, arr, target, targets) ? 1 : 0) == 1;
        }
    }

    // Tabulation
    class Solution3 {

        static Boolean isSubsetSum(int arr[], int target) {
            int n = arr.length;
            int sum = 0;
            for (int i : arr) sum += i;

            int[][] targets = new int[n][target + 1];
            //Base case
            if (arr[0] <= target) targets[0][arr[0]] = 1;
            for (int i = 0; i < n; i++) targets[i][0] = 1;

            for (int i = 1; i < n; i++) {
                for (int t = 1; t <= target; t++) {
                    int pick = 0;
                    int notpick = 0;
                    if (t - arr[i] >= 0) pick = targets[i - 1][t - arr[i]];
                    notpick = targets[i - 1][t];
                    if (pick == 1 || notpick == 1) targets[i][t] = 1;
                }
            }
            return targets[n - 1][target] == 1;
        }
    }
}
