package com.dynamicprogramming;

import java.util.Arrays;

//174. Dungeon Game
//https://leetcode.com/problems/dungeon-game/
public class DungeonGame {
    public static void main(String[] args) {

    }

    // Recursion solution worst time complexity
    int ans = Integer.MIN_VALUE;
    public int calculateMinimumHP(int[][] dungeon) {
        //int[][] healths = new int[][];
        recFunc(dungeon, 0, 0, 0, 0);
        if(ans >= 0) return 1;
        return ans*-1+1;
    }

    void recFunc(int[][] dungeon, int health, int r, int c, int min) {
        health+=dungeon[r][c];

        if(min > health) min = health;

        if(r==dungeon.length-1 && c == dungeon[r].length-1) {
            //System.out.println(health +" r "+r+" c "+ c);
            if(min > ans) ans = min;
            return;
        }
        if(c < dungeon[r].length-1) recFunc(dungeon, health, r,c+1, min);
        if(r < dungeon.length-1) recFunc(dungeon, health, r+1,c, min);
    }

    // Method using DP (3ms)
    public int calcMinHealth(int[][] dungeon){
        int[][] minHealthsDP = new int[dungeon.length][dungeon[0].length];
        for(int[] row : minHealthsDP) Arrays.fill(row,Integer.MAX_VALUE);

        for(int c=dungeon[0].length-1;c>=0;c--){
            for(int r=dungeon.length-1;r>=0;r--){
                int right = 0;
                int down = 0;
                int nextMin=0;

                if(c+1<dungeon[0].length) right = minHealthsDP[r][c+1];
                if(r+1<dungeon.length) down = minHealthsDP[r+1][c];
                if(right > 0 && down > 0) nextMin = Math.min(right, down);
                else nextMin = Math.max(right,down);

                if(nextMin==0) nextMin = 1;
                int requiredHealth = 0;

                if(dungeon[r][c] < 0) {
                    requiredHealth = nextMin + (-1)*dungeon[r][c];
                }else if(dungeon[r][c] >= 0){
                    requiredHealth = nextMin - dungeon[r][c];
                }
                if(dungeon[r][c] > nextMin || requiredHealth==0) requiredHealth = 1 ;
                if(requiredHealth < minHealthsDP[r][c]) minHealthsDP[r][c] = requiredHealth;

            }
        }
        return minHealthsDP[0][0];
    }

}
