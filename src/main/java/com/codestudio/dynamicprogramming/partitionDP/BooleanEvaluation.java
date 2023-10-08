package com.codestudio.dynamicprogramming.partitionDP;

//Boolean Evaluation
//https://www.codingninjas.com/studio/problems/problem-name-boolean-evaluation_1214650?leftPanelTab=0
//Striver DP series vid 52
public class BooleanEvaluation {
    //Normal recursion solution with TC = O(4^n)*n and SC = O(n)
    //getting TLE error
    static int mod = 1000000007;
    public static int evaluateExp(String exp) {
        return rec(0,exp.length()-1,exp,true);
    }

    public static int rec(int i, int j, String exp, boolean isTrue){
        if(i > j) return 0;
        if(i == j){
            if(exp.charAt(i) == 'T') return isTrue ? 1 : 0;
            else if(exp.charAt(i) == 'F') return isTrue ? 0 : 1;
        }

        int count = 0;

        for(int p=i+1;p<j;p+=2){
            int lt = rec(i,p-1,exp,true);
            int lf = rec(i,p-1,exp,false);
            int rt = rec(p+1,j,exp,true);
            int rf = rec(p+1,j,exp,false);

            int ways = 0;
            if(isTrue){
                if(exp.charAt(p) == '|') ways = lt*rt + lt*rf + lf*rt;
                else if(exp.charAt(p) == '&') ways = lt*rt;
                else if(exp.charAt(p) == '^') ways = lt*rf + lf*rt;
                count = count+ways%mod;
            }
            else {
                if(exp.charAt(p) == '|') ways = lf*rf;
                else if(exp.charAt(p) == '&') ways = lf*rf + lt*rf + lf*rt;
                else if(exp.charAt(p) == '^') ways = lt*rt + lf*rf;
                count = count+ways%mod;
            }
        }

        return count%mod;
    }

    //recursion with memoization solution with TC = O(n*n)*n and SC = O(n) + dp[n+2][n+2][2]
    public static int evaluateExpMem(String exp) {
        int n = exp.length();
        int[][][] dp = new int[n][n][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return (int)recMem(0,exp.length()-1,exp,1,dp);
    }

    public static long recMem(int i, int j, String exp, int isTrue, int[][][] dp){
        if(i > j) return 0;
        if(i == j){
            if(exp.charAt(i) == 'T') {
                return isTrue == 1 ? 1 : 0;
            }
            else if(exp.charAt(i) == 'F'){
                return isTrue == 0 ? 1 : 0;
            }
        }

        if(dp[i][j][isTrue] != -1 ) return dp[i][j][isTrue];

        long count = 0;

        for(int p=i+1;p<j;p+=2){
            long lt = recMem(i,p-1,exp,1,dp)% mod;
            long lf = recMem(i,p-1,exp,0,dp)% mod;
            long rt = recMem(p+1,j,exp,1,dp)% mod;
            long rf = recMem(p+1,j,exp,0,dp)% mod;

            long ways = 0;
            if(isTrue == 1){
                if(exp.charAt(p) == '|') ways = lt*rt% mod + lt*rf% mod + lf*rt% mod;
                else if(exp.charAt(p) == '&') ways = lt*rt% mod;
                else if(exp.charAt(p) == '^') ways = lt*rf% mod + lf*rt% mod;
                count = (count+ways)%mod;
            }
            else {
                if(exp.charAt(p) == '|') ways = lf*rf% mod;
                else if(exp.charAt(p) == '&') ways = lf*rf% mod + lt*rf% mod + lf*rt% mod;
                else if(exp.charAt(p) == '^') ways = lt*rt% mod + lf*rf% mod;
                count = (count+ways)%mod;
            }
        }

        dp[i][j][isTrue] = (int)count;
        return dp[i][j][isTrue];
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*n)*n , SC = dp[n+2][n+2][2]
    public static int evaluateExpTabulation(String exp) {
        int n = exp.length();
        int[][][] dp = new int[n+2][n+2][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int isTrue=0;isTrue<=1;isTrue++){
                    if(i == j){
                        if(exp.charAt(i) == 'T') {
                            dp[i][j][isTrue] = isTrue == 1 ? 1 : 0;
                        }
                        else if(exp.charAt(i) == 'F'){
                            dp[i][j][isTrue] = isTrue == 0 ? 1 : 0;
                        }
                    }
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                for(int isTrue=0;isTrue<=1;isTrue++){
                    long count = 0;

                    for(int p=i+1;p<j;p+=2){
                        long lt = dp[i][p-1][1]% mod;
                        long lf = dp[i][p-1][0]% mod;
                        long rt = dp[p+1][j][1]% mod;
                        long rf = dp[p+1][j][0]% mod;

                        long ways = 0;
                        if(isTrue == 1){
                            if(exp.charAt(p) == '|') ways = lt*rt% mod + lt*rf% mod + lf*rt% mod;
                            else if(exp.charAt(p) == '&') ways = lt*rt% mod;
                            else if(exp.charAt(p) == '^') ways = lt*rf% mod + lf*rt% mod;
                            count = (count+ways)%mod;
                        }
                        else {
                            if(exp.charAt(p) == '|') ways = lf*rf% mod;
                            else if(exp.charAt(p) == '&') ways = lf*rf% mod + lt*rf% mod + lf*rt% mod;
                            else if(exp.charAt(p) == '^') ways = lt*rt% mod + lf*rf% mod;
                            count = (count+ways)%mod;
                        }
                    }

                    dp[i][j][isTrue] = (int)count;
                }
            }
        }
        return dp[0][n-1][1];
    }
}
