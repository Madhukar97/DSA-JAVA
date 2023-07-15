package com.codestudio.dynamicprogramming.strings;

//Longest Common Substring
//https://www.codingninjas.com/studio/problems/longest-common-substring_1235207
public class LongestCommonSubstring {
    static int ans = 0;
    public static void main(String[] args) {
        String s = "zsfsdafwe";
        System.out.println(s.substring(0,s.length()-1));
    }
    public static int lcs(String str1, String str2) {
        ans = 0;
        int n=str1.length();
        int m=str2.length();

        rec(n-1,m-1,str1,str2);
        return ans;
    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    // NOTE:: failing for some test cases in both leetcode and codestudio
    public static int rec(int i1, int i2, String s1, String s2){
        if(i1<0 || i2<0){
            return 0;
        }

        if(s1.charAt(i1) == s2.charAt(i2)) {
            int length = 1+rec(i1-1,i2-1,s1,s2);
            ans = Math.max(ans,length);
            return length;
        }

        // try remaining possible ways
        rec(i1-1,i2,s1,s2);
        rec(i1,i2-1,s1,s2);
        return 0;
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public static int lcsTabulation(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][] dp = new int[n+1][m+1];
        int ans=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return ans;
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*m) , SC = 2*dp[m+1] :: 2 array space optimization
    public static int lcsTabulationWithSpaceOptimization(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        int ans=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                    ans = Math.max(ans, curr[j]);
                }
                else curr[j] = 0;
            }
            prev=curr;
            curr = new int[m+1];
        }
        return ans;
    }

}
