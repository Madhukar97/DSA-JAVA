package com.trees;

import java.util.ArrayList;
import java.util.List;

//590. N-ary Tree Postorder Traversal
public class N_aryTreePostorderTraversal {
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
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        recFunc(root, ans);
        return ans;
    }

    static void recFunc(Node root, List<Integer> ans) {
        if(root == null) return;
        for(Node node : root.children) {
            recFunc(node, ans);
        }
        ans.add(root.val);
    }
}
