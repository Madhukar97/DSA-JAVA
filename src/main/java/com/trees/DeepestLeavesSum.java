package com.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//1302. Deepest Leaves Sum
//https://leetcode.com/problems/deepest-leaves-sum/
public class DeepestLeavesSum {
    public static void main(String[] args) {
    }
    public class TreeNode {
        int val;
        DeepestLeavesSum.TreeNode left;
        DeepestLeavesSum.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, DeepestLeavesSum.TreeNode left, DeepestLeavesSum.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //using Queue DataStructure ans iteration
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int ans = 0;


        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if(current == null) {
                if(queue.isEmpty()) break;
                else {
                    queue.add(null);
                    ans = 0;
                }
            }
            else {
                ans+=current.val;
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }

        }
        return ans;

    }

    //using HashMap DataStructure and recursion
    public int deepestLeavesSum2(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        recFunc(map, root, 1);
        int pKey = 1;
        int ans = 0;
        for(int key : map.keySet()) {
            if(key > pKey)  ans = map.get(key);
        }
        return ans;
    }

    void recFunc(HashMap<Integer, Integer> map, TreeNode root, int lvl) {
        if(root == null) return;

        if(map.containsKey(lvl)) {
            map.put(lvl, map.get(lvl) + root.val);
        }else map.put(lvl, root.val);

        if(root.left != null) recFunc(map, root.left, lvl+1);
        if(root.right != null) recFunc(map, root.right, lvl+1);
    }

}
