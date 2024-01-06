package com.trees.bst;

import com.trees.BinaryTreeLevelOrderTraversal;

import java.util.*;

//653. Two Sum IV - Input is a BST
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
public class TwoSumIVInputIsABST {
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

    //Better sol using hashing
    HashSet<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);

        if(findTarget(root.left, k)) return true;
        return findTarget(root.right, k);

    }

    //Optimal sol using 2 pointer method
    //Optimal : use BST Iterators next and prev and do 2 pointer search with time (n) and space O(h*2)
    class BSTIterator{
        Stack<TreeNode> stack;
        boolean reverse;

        public BSTIterator(TreeNode root, boolean reverse) {
            this.stack = new Stack<>();
            this.reverse = reverse;
            pushAll(root);
        }

        public int next() {
            TreeNode curr = stack.pop();
            if(!reverse) pushAll(curr.right);
            else pushAll(curr.left);
            return curr.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushAll(TreeNode node){
            if(!reverse){
                while( node != null){
                    stack.push(node);
                    node=node.left;
                }
            }else{
                while(node!=null){
                    stack.push(node);
                    node=node.right;
                }
            }
        }
    }
    public boolean findTargetSol2(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);
        int start = l.next();
        int end = r.next();

        while(start < end){
            int sum = start + end;
            if(sum == k) return true;
            else if(sum < k) start = l.next();
            else end = r.next();
        }
        return false;
    }

    //Revision 1
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            BSTIterator it = new BSTIterator(root);
            boolean ans=false;

            int left = it.next();
            int right = it.prev();

            while(left < right){
                int sum = left+right;
                if(sum == k) return true;
                else if(sum < k) left = it.next();
                else right = it.prev();
            }
            return ans;
        }


        public class BSTIterator{
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            public BSTIterator(TreeNode node){
                pushAllLeft(node);
                pushAllRight(node);
            }

            public int next(){
                TreeNode next = stack.pop();
                pushAllLeft(next.right);
                return next.val;
            }

            public boolean hasNext(){
                return !stack.isEmpty();
            }

            public int prev(){
                TreeNode prev = stack2.pop();
                pushAllRight(prev.left);
                return prev.val;
            }

            public boolean hasPrev(){
                return !stack2.isEmpty();
            }

            public void pushAllLeft(TreeNode node){
                while(node != null) {
                    stack.add(node);
                    node=node.left;
                }
            }

            public void pushAllRight(TreeNode node){
                while(node != null) {
                    stack2.add(node);
                    node=node.right;
                }
            }

        }
    }

    //Revision 2
    class Solution2 {
        public boolean findTarget(TreeNode root, int k) {
            BSTIterator it = new BSTIterator(root);
            int left = it.next();
            int right = it.prev();
            while(left != right){
                int sum = left+right;
                if(sum == k) return true;
                else if(sum < k) left = it.next();
                else right = it.prev();
            }
            return false;
        }

        class BSTIterator{
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            public BSTIterator(TreeNode root){
                pushAllLeft(root);
                pushAllRight(root);
            }

            public int next(){
                TreeNode node = stack.pop();
                pushAllLeft(node.right);
                return node.val;
            }

            public int prev(){
                TreeNode node = stack2.pop();
                pushAllRight(node.left);
                return node.val;
            }

            public void pushAllLeft(TreeNode node){
                while(node != null){
                    stack.add(node);
                    node=node.left;
                }
            }

            public void pushAllRight(TreeNode node){
                while(node != null){
                    stack2.add(node);
                    node=node.right;
                }
            }
        }
    }
}
