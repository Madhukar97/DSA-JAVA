package com.codestudio.dynamicprogramming.strings;

//Wildcard Pattern Matching
//https://www.codingninjas.com/studio/problems/wildcard-pattern-matching_701650
//Striver DP series vid 34
public class WildcardPatternMatching {
    public static void main(String[] args) {
        System.out.println(false ? 1 : 0);
    }
    public static boolean wildcardMatching(String pattern, String text) {
        return rec(pattern.length()-1,text.length()-1,pattern,text);
    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    public static boolean rec(int i1, int i2, String pt, String t){
        //base case
        if(i1<0 && i2<0) return true;
        else if(i1<0 && i2>=0) return false;
        else if(i1 >=0 && i2<0) {
            for(int c=0;c<=i1;c++){
                if(pt.charAt(c) != '*') return false;
            }
            return true;
        }

        //all possibilities
        if(pt.charAt(i1) ==  t.charAt(i2) || pt.charAt(i1) == '?') return rec(i1-1,i2-1,pt,t);
        else if(pt.charAt(i1) == '*') {
            return rec(i1-1,i2,pt,t) || rec(i1,i2-1,pt,t);

        }
        else return false;
    }

    public static boolean wildcardMatchingMem(String pattern, String text) {
        int n=pattern.length();
        int m=text.length();
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        return recMem(pattern.length()-1,text.length()-1,pattern,text,dp);
    }
    //Recursion with Memoization(Top-Down approach) solution TC = O(n*m) , SC = O(n+m) + dp[n][m]
    public static boolean recMem(int i1, int i2, String pt, String t, int[][] dp ){
        //base case
        if(i1<0 && i2<0) return true;
        else if(i1<0 && i2>=0) return false;
        else if(i1 >=0 && i2<0) {
            for(int c=0;c<=i1;c++){
                if(pt.charAt(c) != '*') return false;
            }
            return true;
        }

        if(dp[i1][i2] != -1) {
            if(dp[i1][i2] == 1) return true;
            else return false;
        }

        //all possibilities
        if(pt.charAt(i1) ==  t.charAt(i2) || pt.charAt(i1) == '?') {
            boolean val = recMem(i1-1,i2-1,pt,t,dp);
            dp[i1][i2] = val ? 1 : 0;
            return val;
        }
        else if(pt.charAt(i1) == '*') {
            boolean val = recMem(i1-1,i2,pt,t,dp) || recMem(i1,i2-1,pt,t,dp);
            dp[i1][i2] = val ? 1 : 0;
            return val;
        }
        dp[i1][i2] = 0;
        return false;
    }
    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public static boolean wildcardMatchingTabulation(String pattern, String text) {
        int n=pattern.length();
        int m=text.length();
        boolean[][] dp = new boolean[n+1][m+1];

        //base case
        dp[0][0] = true;
        for(int j=1;j<m+1;j++) dp[0][j] = false;
        for(int i=1;i<n+1;i++) {
            dp[i][0] = true;
            for(int c=1;c<=i;c++){
                if(pattern.charAt(c-1) != '*') {
                    dp[i][0] = false;
                    break;
                }
            }
        }

        for(int i1=1;i1<n+1;i1++){
            for(int i2=1;i2<m+1;i2++){
                if(pattern.charAt(i1-1) ==  text.charAt(i2-1) || pattern.charAt(i1-1) == '?') {
                    dp[i1][i2] = dp[i1-1][i2-1];
                }
                else if(pattern.charAt(i1-1) == '*') {
                    dp[i1][i2] = dp[i1-1][i2] || dp[i1][i2-1];
                }
                else dp[i1][i2] = false;
            }
        }
        return dp[n][m];
    }
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*m) , SC = 2*dp[m+1]
    public static boolean wildcardMatchingTabWithSpaceOptimization(String pattern, String text) {
        int n=pattern.length();
        int m=text.length();
        boolean[] prev = new boolean[m+1];
        boolean[] curr = new boolean[m+1];

        //base case
        prev[0] = true;
        for(int j=1;j<m+1;j++) prev[j] = false;

        for(int i1=1;i1<n+1;i1++){
            //for every row 0th column should have astrisk(*) subString is present or not from 0->i1
            curr[0] = true;
            for(int c=1;c<=i1;c++){
                if(pattern.charAt(c-1) != '*') {
                    curr[0] = false;
                    break;
                }
            }

            for(int i2=1;i2<m+1;i2++){
                if(pattern.charAt(i1-1) ==  text.charAt(i2-1) || pattern.charAt(i1-1) == '?') {
                    curr[i2] = prev[i2-1];
                }
                else if(pattern.charAt(i1-1) == '*') {
                    curr[i2] = prev[i2] || curr[i2-1];
                }
                else curr[i2] = false;
            }
            prev=curr;
            curr=new boolean[m+1];
        }
        return prev[m];
    }
}
