package com.heaps;

import java.util.PriorityQueue;

//973. K Closest Points to Origin
//https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPointsToOrigin {
    //Sol using minHeap
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2)->{
            double diff = n1.dist-n2.dist;
            if(diff == 0) return 0;
            else if(diff < 0) return -1;
            return 1;
        });
        for(int[] point : points) minHeap.add(new Node(point[0], point[1]));

        int[][] ans = new int[k][2];
        for(int i=0;i<k;i++){
            Node point = minHeap.poll();
            ans[i][0] = point.x;
            ans[i][1] = point.y;
        }
        return ans;
    }

    public class Node{
        int x;
        int y;
        double dist;

        public Node(int x, int y){
            this.x=x;
            this.y=y;
            this.dist = Math.sqrt(x*x+y*y);
        }
    }
}
