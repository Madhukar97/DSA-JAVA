package com.trie;

//Maximum XOR of Two Numbers in an Array
//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
public class MaximumXOROfTwoNumbersInAnArray {
    //Using Trie Datastructure with TC = O(n*32) + O(n*32) ans SC cant determined
    public int findMaximumXOR(int[] nums) {
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
