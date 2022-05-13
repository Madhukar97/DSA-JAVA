package com.trees;

import java.util.LinkedList;
import java.util.Queue;

//116. Populating Next Right Pointers in Each Node
//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextRightPointersinEachNode {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Integer x = queue.peek();
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()) {
            Node current = queue.poll();

            if(current == null) {
                if(queue.isEmpty()) break;
                else {
                    queue.add(null);
                }
            }

            if(current != null) {
                current.next = queue.peek();
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }

        }
        return root;
    }
}
