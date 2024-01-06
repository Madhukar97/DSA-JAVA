package com.graphs;

import java.util.*;

//133. Clone Graph
//https://leetcode.com/problems/clone-graph/
public class CloneGraph {
// Definition for a Node.
     class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {
        public Node cloneGraph(Node node) {
            if(node == null) return null;
            Node copy = new Node(node.val);
            Node[] vis = new Node[101];
            dfs(node, copy, vis);
            return copy;
        }

        public void dfs(Node node, Node copy, Node[] vis){
            vis[copy.val] = copy;

            for(Node neighbour : node.neighbors){
                if(vis[neighbour.val] == null){
                    Node neighbourCopy = new Node(neighbour.val);
                    copy.neighbors.add(neighbourCopy);
                    dfs(neighbour, neighbourCopy, vis);
                }else {
                    copy.neighbors.add(vis[neighbour.val]);
                }
            }
        }
    }
}
