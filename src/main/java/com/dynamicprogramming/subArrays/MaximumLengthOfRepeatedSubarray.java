package com.dynamicprogramming.subArrays;

//718. Maximum Length of Repeated Subarray
//https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
public class MaximumLengthOfRepeatedSubarray {
    int ans=0;
    public static void main(String[] args) {

    }
    //Normal recursion solution with TC = O(2^n*2^m) and SC = O(n+m)
    // NOTE:: failing for some test cases in both leetcode and codestudio
    public int rec(int i1, int i2, int[] nums1, int[] nums2){
        if(i1<0 || i2<0) return 0;

        if(nums1[i1] == nums2[i2]){
            int currLen = 1+rec(i1-1,i2-1,nums1,nums2);
            ans=Math.max(ans,currLen);
            return currLen;
        }

        rec(i1-1,i2,nums1,nums2);
        rec(i1,i2-1,nums1,nums2);
        return 0;
    }

    //Tabulation(Bottom-up approach) solution TC = O(n*m) , SC = dp[n+1][m+1]
    public int findLengthTabulation(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else dp[i][j]=0;
            }
        }
        return ans;
    }

    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*m) , SC = 2*dp[m+1] :: 2 array space optimization
    public int findLengthTabulationWithSpaceOptimization(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1] == nums2[j-1]) {
                    curr[j] = 1+prev[j-1];
                    ans = Math.max(ans, curr[j]);
                }
                else curr[j]=0;
            }
            prev=curr;
            curr = new int[m+1];
        }
        return ans;
    }

}
