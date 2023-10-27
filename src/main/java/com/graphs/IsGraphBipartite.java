package com.graphs;

import java.util.*;

//785. Is Graph Bipartite?
//https://leetcode.com/problems/is-graph-bipartite/
public class IsGraphBipartite {
    //Sol using DFS and colors[] array
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for(int i=0;i<graph.length;i++){
            if(colors[i] == -1){
                if(!dfs(graph,colors,i,0)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] colors, int index, int color){
        colors[index]=color;
        int nextColor = color == 0 ? 1: 0;

        for(int neighbour : graph[index]){
            if(colors[neighbour] == -1){
                if(!dfs(graph,colors,neighbour,nextColor)) return false;
            }else if(colors[neighbour] == color) return false;
        }
        return true;
    }

    //Sol using BFS and colors[] and Node{index,color} class
    public boolean isBipartiteSol2(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for(int i=0;i<graph.length;i++){
            if(colors[i] == -1){
                if(!bfs(graph,colors,i,0)) return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int[] colors, int index, int color){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(index,color));

        while(!q.isEmpty()){
            Node node = q.poll();
            int nodeIndex = node.index;
            int nodeColor = node.color;

            for(int neighbour : graph[nodeIndex]){
                if(colors[neighbour] == -1){
                    colors[neighbour] = nodeColor == 0 ? 1 : 0;
                    q.add(new Node(neighbour, colors[neighbour]));
                }else if(colors[neighbour] == nodeColor) return false;
            }
        }
        return true;
    }

    public class Node{
        int index;
        int color;

        public Node(int i, int c){
            this.index=i;
            this.color=c;
        }
    }
}
