package com.heaps;

import java.util.PriorityQueue;

//1779. Find Nearest Point That Has the Same X or Y Coordinate
//https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    //Better sol using minHeap
    public int nearestValidPoint(int x, int y, int[][] points) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2)->n1.dist-n2.dist);
        for(int i=points.length-1;i>=0;i--){
            int[] point = points[i];
            if(point[0] != x && point[1] != y) continue;
            Node currNode = new Node(point[0], point[1], i, x, y);
            if(minHeap.isEmpty()) minHeap.add(currNode);
            else{
                Node prevNode = minHeap.peek();
                if(prevNode.dist >= currNode.dist){
                    minHeap.poll();
                    minHeap.add(currNode);
                }
            }
        }
        if(minHeap.isEmpty()) return -1;
        return minHeap.poll().index;

    }

    public class Node{
        int x;
        int y;
        int dist;
        int index;

        public Node(int x, int y ,int i, int x1, int y1){
            this.x=x;
            this.y=y;
            this.index=i;
            this.dist = Math.abs(x-x1)+Math.abs(y-y1);
        }
    }
}
