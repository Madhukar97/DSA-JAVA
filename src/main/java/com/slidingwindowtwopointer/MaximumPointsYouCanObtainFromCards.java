package com.slidingwindowtwopointer;

//1423. Maximum Points You Can Obtain from Cards
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class MaximumPointsYouCanObtainFromCards {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int l=0;
            int r=n-1-k;
            int total=0;
            for(int p : cardPoints) total+=p;
            if(r<0) return total;
            int score = 0;
            for(int i=0;i<=r;i++) score+=cardPoints[i];
            int minScoreOmitted = score;


            while(r<n-1){
                score-=cardPoints[l++];
                score+=cardPoints[++r];
                minScoreOmitted = Math.min(minScoreOmitted, score);
            }
            return total-minScoreOmitted;
        }
    }
}
