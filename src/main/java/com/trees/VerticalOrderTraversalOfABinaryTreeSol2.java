package com.trees;

import java.util.*;

//987. Vertical Order Traversal of a Binary Tree
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalOrderTraversalOfABinaryTreeSol2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //Sol using dfs and recursion
    //use outer map to store horizontal.dist , TreeMap to store levels in ascending order, PriorityQueue to store values of overlapping h,v in ascending order
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        rec(root,map,0,0);

        for(int key : map.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> tmap = map.get(key);
            List<Integer> subList = new ArrayList<>();
            for(int key2 : tmap.keySet()){
                PriorityQueue<Integer> pq = tmap.get(key2);
                while(!pq.isEmpty()) subList.add(pq.poll());
            }
            ans.add(subList);
        }
        return ans;
    }

    public void rec(TreeNode root, Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map, int h, int v){
        if(root == null) return;

        map.putIfAbsent(h, new TreeMap<>());
        map.get(h).putIfAbsent(v, new PriorityQueue<>());
        map.get(h).get(v).add(root.val);

        rec(root.left, map, h-1,v+1);
        rec(root.right, map, h+1,v+1);
    }

    //Sol 2 using queue and level order traversal
    public List<List<Integer>> verticalTraversalSol2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,root));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int h=tuple.h;
            int v=tuple.v;

            map.putIfAbsent(h, new TreeMap<>());
            map.get(h).putIfAbsent(v, new PriorityQueue<>());
            map.get(h).get(v).add(node.val);

            if(node.left != null) q.add(new Tuple(h-1,v+1,node.left));
            if(node.right != null) q.add(new Tuple(h+1,v+1,node.right));
        }

        for(int key : map.keySet()){
            TreeMap<Integer, PriorityQueue<Integer>> tmap = map.get(key);
            List<Integer> subList = new ArrayList<>();
            for(int key2 : tmap.keySet()){
                PriorityQueue<Integer> pq = tmap.get(key2);
                while(!pq.isEmpty()) subList.add(pq.poll());
            }
            ans.add(subList);
        }
        return ans;
    }

    class Tuple{
        int h;
        int v;
        TreeNode node;

        public Tuple(int h, int v, TreeNode node){
            this.h=h;
            this.v=v;
            this.node=node;
        }
    }

    //Optimal sol 2
    //Revision 1
    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, List<Tuple>> map = new TreeMap<>();
            Queue<Tuple> q = new LinkedList<>();
            q.add(new Tuple(root,0,0));

            while(!q.isEmpty()){
                Tuple curr = q.poll();

                map.putIfAbsent(curr.x, new ArrayList<>());
                map.get(curr.x).add(curr);
                if(curr.node.left != null) q.add(new Tuple(curr.node.left, curr.x-1, curr.y+1));
                if(curr.node.right != null) q.add(new Tuple(curr.node.right, curr.x+1, curr.y+1));
            }
            for(int k : map.keySet()) {
                List<Tuple> tuples = map.get(k);
                Collections.sort(tuples, (t1,t2) -> t1.y==t2.y ? t1.node.val-t2.node.val : t1.y-t2.y);
                List<Integer> list = new ArrayList<>();
                for(Tuple t  :tuples) list.add(t.node.val);
                ans.add(list);
            }
            return ans;
        }

        public class Tuple{
            TreeNode node;
            int x;
            int y;

            public Tuple(TreeNode n, int x, int y){
                node=n;
                this.x=x;
                this.y=y;
            }
        }
    }

    //Revision 2
    //Optimal sol 3 using BFS Queue, Map and PriorityQueue
    class Solution3 {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            Map<Integer, PriorityQueue<Pair>> map = new TreeMap<>();
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0, 0));
            int level=0;
            while(!q.isEmpty()){
                int size = q.size();

                for(int i=0;i<size;i++){
                    Pair pair = q.poll();
                    TreeNode node = pair.node;


                    map.putIfAbsent(pair.x, new PriorityQueue<>( (p1,p2) -> {
                        if(p1.y != p2.y) return p1.y-p2.y;
                        else return p1.node.val-p2.node.val;
                    }));
                    map.get(pair.x).add(pair);
                    if(node.left != null) q.add(new Pair(node.left, pair.x-1, level+1));
                    if(node.right != null) q.add(new Pair(node.right, pair.x+1, level+1));
                }
                level++;
            }

            List<List<Integer>> ans = new ArrayList<>();
            for(int x : map.keySet()){
                PriorityQueue<Pair> yList = map.get(x);
                List<Integer> list = new ArrayList<>();
                while(!yList.isEmpty()) list.add(yList.poll().node.val);
                ans.add(list);
            }
            return ans;
        }

        public class Pair{
            TreeNode node;
            int x;
            int y;

            public Pair(TreeNode n, int h, int v){
                node=n;
                x=h;
                y=v;
            }
        }
    }
}
