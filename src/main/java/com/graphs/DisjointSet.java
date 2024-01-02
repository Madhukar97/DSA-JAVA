package com.graphs;

//Striver Graph series G 46 video
//Can only be used for undirected graph
public class DisjointSet {
    int[] parent;
    int[] rank;
    int[] size;

    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
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
        if(ultimateParentOfU == ultimateParentOfV) return;
        if(rank[ultimateParentOfU] < rank[ultimateParentOfV]){
            parent[ultimateParentOfU] = ultimateParentOfV;
        }else if(rank[ultimateParentOfU] > rank[ultimateParentOfV]){
            parent[ultimateParentOfV] = ultimateParentOfU;
        }else{
            parent[ultimateParentOfV] = ultimateParentOfU;
            rank[ultimateParentOfU]++;
        }
    }

    public void unionBySize(int u, int v){
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);
        if(ultimateParentOfU == ultimateParentOfV) return; //they belong to same component
        if(size[ultimateParentOfU] < size[ultimateParentOfV]){
            parent[ultimateParentOfU] = ultimateParentOfV;
            size[ultimateParentOfV] = size[ultimateParentOfV] + size[ultimateParentOfU];
        }else{
            parent[ultimateParentOfV] = ultimateParentOfU;
            size[ultimateParentOfV] = size[ultimateParentOfV] + size[ultimateParentOfU];
        }
    }

    public boolean detectCycle(int u, int v){
        int ultimateParentOfU = findUltimateParent(u);
        int ultimateParentOfV = findUltimateParent(v);
        // System.out.println("upU of " + u+" : "+ ultimateParentOfU + ", upV "+v+ " : "+ ultimateParentOfV);
        return  ultimateParentOfU == ultimateParentOfV;
    }
}
