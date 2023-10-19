package com.trees;

import java.util.*;

//Top View Of Binary Tree
//https://www.codingninjas.com/studio/problems/top-view-of-binary-tree_799401?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
//https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
public class TopViewOfBinaryTree {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    //Sol using level order traversal
    public static List<Integer> getTopView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, TreeNode> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, root));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int h=tuple.h;

            map.putIfAbsent(h, node);

            if(node.left != null) q.add(new Tuple(h-1,node.left));
            if(node.right != null) q.add(new Tuple(h+1,node.right));
        }

        for(int key : map.keySet()){
            ans.add(map.get(key).data);
        }
        return ans;
    }

    static class Tuple{
        int h;
        TreeNode node;

        public Tuple(int h, TreeNode node){
            this.h=h;
            this.node=node;
        }
    }
}
