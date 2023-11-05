package com.trie;

//421. Maximum XOR of Two Numbers in an Array
//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
public class MaximumXOROfTwoNumbersInAnArray {
    public static void main(String[] args) {
        System.out.println("NUM : " + (3 >> 0 & 1)); // we are right shifting num by i times and doing & 1 because : >> 0 will give the num instead of bit
    }
    //Brute Force
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                ans = Math.max(ans, nums[i] ^ nums[j]);
            }
        }
        return ans;
    }

    //Optimal sol Using Trie Datastructure with TC = O(n*32) + O(n*32) ans SC = O(2^32-1) ~ O(1)
    //A complete (in other words: full) binary tree has (2^h - 1) nodes, so our Trie here can have at most (2^32 - 1) nodes
    public int findMaximumXORSol2(int[] nums) {
        Trie trie = new Trie();
        for(int n : nums) trie.insert(n);

        int ans = 0;
        for(int n : nums){
            ans = Math.max(ans, trie.getMax(n));
        }
        return ans;
    }

    class Trie{
        Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(int num){
            Node pointer = root;
            for(int i=31;i>=0;i--){
                int bit = (num >> i) & 1;
                if(!pointer.contains(bit)){
                    pointer.put(bit, new Node());
                }
                pointer = pointer.get(bit);
            }
        }

        public int getMax(int num){
            Node pointer = root;
            int max=0;
            for(int i=31;i>=0;i--){
                int bit = (num >> i) & 1;
                if(pointer.contains(1 - bit)){
                    max |= 1<<i;
                    pointer = pointer.get(1-bit);
                }else {
                    pointer = pointer.get(bit);
                }
            }
            return max;
        }
    }

    class Node{
        Node[] links = new Node[2];

        public boolean contains(int bit){
            return links[bit] != null;
        }

        public Node get(int bit){
            return links[bit];
        }

        public void put(int bit, Node node){
            links[bit] = node;
        }
    }

}
