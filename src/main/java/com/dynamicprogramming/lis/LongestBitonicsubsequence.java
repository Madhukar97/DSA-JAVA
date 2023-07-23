package com.dynamicprogramming.lis;

//Longest Bitonic subsequence
//https://www.codingninjas.com/studio/problems/longest-bitonic-sequence_1062688?leftPanelTab=0
//https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
//Striver DP series vid 46
import java.util.Arrays;

public class LongestBitonicsubsequence {
    public static void main(String[] args) {
        int[] arr =new int[]{20,7,9,6,9,21,12,3,12,16,1,27};
        LongestBitonicSequence(arr);

    }

    public static int LongestBitonicSequence(int[] arr)
    {
        int n=arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++) dp[i]=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
        }

        int ans=0;
        int[] dp2 = new int[n];
        for(int i=0;i<n;i++) dp2[i]=1;

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if( arr[i] > arr[j]){
                    dp2[i] = Math.max(dp2[i], 1+dp2[j]);
                }
            }
        }

//         System.out.println("DP1 :: " + Arrays.toString(dp));
//         System.out.println("DP2 :: " + Arrays.toString(dp2));
        for(int i=0;i<n;i++){
            ans=Math.max(ans, dp[i]+dp2[i]-1);
        }
        return ans;
    }
}
