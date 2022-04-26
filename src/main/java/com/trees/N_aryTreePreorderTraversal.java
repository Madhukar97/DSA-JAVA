package com.trees;

import java.util.ArrayList;
import java.util.List;

//589. N-ary Tree Preorder Traversal
public class N_aryTreePreorderTraversal {
    public static void main(String[] args) {

    }
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
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        recFunc(root, ans);
        return ans;
    }

    static void recFunc(Node root, List<Integer> ans) {
        if(root == null) return;
        ans.add(root.val);
        for(Node node : root.children) {
            recFunc(node, ans);
        }
    }
}
