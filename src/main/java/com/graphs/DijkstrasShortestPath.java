package com.graphs;

import java.util.*;

//Dijkstra's shortest path
//https://www.codingninjas.com/studio/problems/920469?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class DijkstrasShortestPath {
    //Same as Dijkstras algorithm
    public static ArrayList< Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
        List<List<Node>> adj = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>((n1,n2)->n1.wt-n2.wt);
        pq.add(new Node(source,0));
        int[] dis = new int[vertices];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source]=0;

        for(int i=0;i<vertices;i++) adj.add(new ArrayList<>());

        for(List<Integer> list : vec){
            int x = list.get(0);
            int y = list.get(1);
            int wt = list.get(2);
            adj.get(x).add(new Node(y, wt));
            adj.get(y).add(new Node(x, wt));
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int index = node.i;
            int wt = node.wt;

            for(Node neighbour : adj.get(index)){
                if(neighbour.wt + wt < dis[neighbour.i]){
                    dis[neighbour.i] = neighbour.wt+wt;
                    pq.add(new Node(neighbour.i, dis[neighbour.i]));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<vertices;i++) ans.add(dis[i]);
        return ans;
    }

    public static class Node{
        int i;
        int wt;

        public Node(int i, int wt){
            this.i=i;
            this.wt=wt;
        }
    }
}
