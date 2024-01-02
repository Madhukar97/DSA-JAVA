package com.graphs;

//Striver Graph series G 46 video
//Can only be used for undirected graph
public class DisjointSet {
    int[] rank;
    int[] parent;

    public DisjointSet(int size){
        rank = new int[size+1];
        parent = new int[size+1];
        for(int i=0;i<=size;i++) parent[i] = i;
    }

    public int findUltimateParent(int node){
        if(node == parent[node]) return node;

        int ultimateParent = findUltimateParent(parent[node]);
        parent[node] = ultimateParent;
        return ultimateParent;
    }

    public void unionByRank(int u, int v){
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);

        if(rank[ultimateParentOfU] < rank[ultimateParentOfV]){
            parent[ultimateParentOfU] = ultimateParentOfV;
        }else if(rank[ultimateParentOfU] > rank[ultimateParentOfV]){
            parent[ultimateParentOfV] = ultimateParentOfU;
        }else{
            parent[ultimateParentOfV] = ultimateParentOfU;
            rank[ultimateParentOfU] = rank[ultimateParentOfV]+1;
        }
    }

    public boolean detectCycle(int u, int v){
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);
        // System.out.println("upU of " + u+" : "+ ultimateParentOfU + ", upV "+v+ " : "+ ultimateParentOfV);
        return  ultimateParentOfU == ultimateParentOfV;
    }
}
