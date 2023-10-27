package com.trees;

//331. Verify Preorder Serialization of a Binary Tree
//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
public class VerifyPreorderSerializationOfABinaryTree {
    //1. For a full binary tree, # of node = # of edges + 1, thus if we manually add an edge to the root, then the # of edges = the # of nodes;
    //2. For a node, it consumes one edge and produces 2 new edges(if not null)
    //If at any point edges < 0 its not valid tree
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int edges =1;
        for(int i=0;i<nodes.length;i++){
            edges--;
            if(edges < 0) return false;;
            if(!nodes[i].equals("#")) edges+=2;
        }
        return edges==0;
    }
}
