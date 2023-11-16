package com.trees;

import java.util.List;

//559. Maximum Depth of N-ary Tree
//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/description/
public class MaximumDepthOfNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //using dfs
    public int maxDepth(Node root) {
        return rec(root);
    }

    public int rec(Node root){
        if(root == null) return 0;

        int ans=0;
        for(Node child : root.children){
            ans = Math.max(ans, rec(child));
        }
        return ans+1;
    }
}
