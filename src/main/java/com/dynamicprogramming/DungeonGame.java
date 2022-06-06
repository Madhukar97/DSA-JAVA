package com.dynamicprogramming;

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

    // Method using DP

}
