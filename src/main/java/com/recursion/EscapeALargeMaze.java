package com.recursion;

import java.util.*;

//1036. Escape a Large Maze
//https://leetcode.com/problems/escape-a-large-maze/description/
public class EscapeALargeMaze {
    /*
    This problem is a classic grid escape problem, with a twist: the grid is huge (1 million × 1 million),
    but only a small number of blocked squares (like ≤ 200) are given. So we cannot simulate the entire grid — we must be smart about the search.

    With at most 200 blocked squares, they can enclose a maximum area, and beyond that area
    we are guaranteed to escape if not enclosed. The maximum area 200 blockers can enclose is limited.

    Let’s define:
    The maximum enclosed area by n blocked cells is approximately n * (n - 1) / 2.
    For n = 200, this is 19900.
    So if from source or target, we can reach more than 19900 distinct unblocked positions,
    we are not enclosed and therefore reachable unless the target is itself enclosed.
     */
    class Solution {
        public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
            HashSet<Long> blockedSet = new HashSet<>();
            for(int[] block : blocked) blockedSet.add(encode(block[0], block[1]));
            return bfs(source, target, blockedSet) && bfs(target, source, blockedSet);
        }

        private boolean bfs(int[] start, int[] end, HashSet<Long> blocked){
            HashSet<Long> visited = new HashSet<>();
            visited.add(encode(start[0], start[1]));
            Queue<int[]> q = new LinkedList<>();
            q.add(start);

            int[] rows = {-1,0,1,0};
            int[] cols = {0,1,0,-1};

            while(!q.isEmpty() && visited.size() < 20000){
                int[] curr = q.poll();

                for(int c=0;c<4;c++){
                    int newX = curr[0] + rows[c];
                    int newY = curr[1] + cols[c];

                    if(newX == end[0] && newY == end[1]) return true;
                    Long code = encode(newX, newY);
                    if(newX<0 || newY<0 || newX==1000000 || newY==1000000 || blocked.contains(code) || visited.contains(code)) continue;
                    q.add(new int[]{newX, newY});
                    visited.add(code);
                }
            }
            return visited.size() >= 20000;
        }

        private long encode(int x, int y){
            return ((long)x<<20) | y;
        }
    }
}
