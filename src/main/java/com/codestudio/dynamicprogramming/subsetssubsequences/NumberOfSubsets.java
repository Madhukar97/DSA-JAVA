package com.codestudio.dynamicprogramming.subsetssubsequences;

//https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532?leftPanelTab=0
//Number Of Subsets
public class NumberOfSubsets {
    public static void main(String[] args) {
        int[] arr= new int[3];

    }

    public static int findWays(int num[], int tar) {
        return rec(num.length-1,tar,num);
    }

    //Normal recursion solution with TC = O(2^n) and SC = O(n)
    public static int rec(int index, int target, int[] nums){
        if( target==0 ) return 1;
        if(index == 0) {
            if(nums[index] == target) return 1;
            else return 0;
        }

        int notPick = rec(index-1,target,nums);
        int pick=0;
        if(nums[index]<=target) pick = rec(index-1,target-nums[index],nums);

        return notPick+pick;
    }

    public static int findWaysMem(int num[], int tar) {
        int[][] dp = new int[num.length][tar+1];
        for(int i=0;i<num.length;i++ ){
            for(int j=0;j<tar+1;j++){
                dp[i][j] = -1;
            }
        }
        return recMem(num.length-1,tar,num,dp);
    }

    //Recursion with Memoization(Top-Down approach) solution TC = O(n*target) , SC = O(n) + dp[n][target+1]
    public static int recMem(int index, int target, int[] nums, int[][] dp){
        if(index==0){
            if(nums[index]==0&&target==0) return 2;
            if(nums[index]==target||target==0 ) return 1;
            return 0;
        }

        if(dp[index][target] != -1) return dp[index][target];

        int notPick = recMem(index-1,target,nums,dp);
        int pick=0;
        if(nums[index]<=target) pick = recMem(index-1,target-nums[index],nums,dp);
        dp[index][target] = notPick+pick;
        return notPick+pick;
    }

    //failing at 12/13 test case in codestudio
    //Tabulation(Bottom-up approach) with space optimization solution TC = O(n*target) , SC = dp[n][target+1]
    public static int findWaysTabulation(int num[], int tar) {
        int[][] dp = new int[num.length][tar+1];

        if(num[0]<=tar) dp[0][num[0]]=1;
        for(int i=0;i<num.length;i++) dp[i][0] = 1;

        for(int index=1;index<num.length;index++){
            for(int target=0;target<=tar;target++){
                int notPick = dp[index-1][target];
                int pick=0;
                if(num[index]<=target) pick = dp[index-1][target-num[index]];
                dp[index][target] = notPick+pick;
            }
        }
        return dp[num.length-1][tar];
    }
}
