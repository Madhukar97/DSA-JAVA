package com.brainteaser;

//2087. Minimum Cost Homecoming of a Robot in a Grid
//https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description/
public class MinimumCostHomecomingOfARobotInAGrid {
    //It's a brain-teaser,all shortest paths have the same cost.
    //The robot cannot avoid going through rows and cols between it and home.
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans=0;
        int x = startPos[0];
        int y = startPos[1];
        int hx = homePos[0];
        int hy = homePos[1];

        while(x != hx){
            if(x-hx < 0) x = x +1;
            else x=x-1;
            ans+=rowCosts[x];
        }

        while(y != hy){
            if(y-hy < 0) y = y+1;
            else y = y-1;
            ans+=colCosts[y];
        }
        return ans;
    }
}
