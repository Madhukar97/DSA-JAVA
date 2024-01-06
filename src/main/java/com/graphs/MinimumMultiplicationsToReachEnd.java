package com.graphs;

import java.util.*;

//Minimum Multiplications to reach End
//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-multiplications-to-reach-end
public class MinimumMultiplicationsToReachEnd {
    //Using Dijkstras algo
    class Solution {
        int minimumMultiplications(int[] arr, int start, int end) {

            int mod = 100000;
            int[] dist = new int[100000];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start]=0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)->a1[1]-a2[1]);
            pq.add(new int[]{start, 0});

            while(!pq.isEmpty()){
                int[] node = pq.poll();
                int num = node[0];
                int multi = node[1];

                if(num == end) return multi;

                for(int i : arr){
                    int newNum = num*i%mod;
                    if(dist[newNum] > multi+1) {
                        dist[newNum] = multi+1;
                        pq.add(new int[]{newNum, multi+1});
                    }
                }
            }
            return -1;
        }
    }
}
