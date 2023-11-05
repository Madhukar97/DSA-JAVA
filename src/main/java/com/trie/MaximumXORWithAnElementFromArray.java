package com.trie;

import java.util.*;

//1707. Maximum XOR With an Element From Array
//https://leetcode.com/problems/maximum-xor-with-an-element-from-array/description/
public class MaximumXORWithAnElementFromArray {
    //Sol using offlineQueries ArrayList with TC = O(Q*32 + N*32)
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            ArrayList<Integer> offlineQuery = new ArrayList<>();
            offlineQuery.add(queries[i][0]);
            offlineQuery.add(queries[i][1]);
            offlineQuery.add(i);
            offlineQueries.add(offlineQuery);
        }
        Collections.sort(offlineQueries, (l1,l2) -> l1.get(1)-l2.get(1));
        // System.out.println("QUERIES : " + offlineQueries.toString());

        Trie trie = new Trie();
        int index=0;
        for(int i=0;i<offlineQueries.size();i++){
            int XOR = -1;
            while(index < nums.length && nums[index] <= offlineQueries.get(i).get(1)){
                trie.insert(nums[index]);
                index++;
            }
            if(index != 0) XOR = trie.getMax(offlineQueries.get(i).get(0));
            ans[offlineQueries.get(i).get(2)] = XOR;
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

    //Sol using offlineQueries POJO class
    public int[] maximizeXorSol2(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        ArrayList<Query> offlineQueries = new ArrayList<>();


        for(int i=0;i<queries.length;i++){
            int[] q = queries[i];
            Query query = new Query(q[0],q[1],i);
            offlineQueries.add(query);
        }
        Collections.sort(offlineQueries, (q1,q2) -> q1.m-q2.m);
        // System.out.println("QUERIES : " + offlineQueries.toString());

        Trie trie = new Trie();
        int index=0;
        for(int i=0;i<offlineQueries.size();i++){
            int XOR = -1;
            while(index < nums.length && nums[index] <= offlineQueries.get(i).m){
                trie.insert(nums[index]);
                index++;
            }
            if(index != 0) XOR = trie.getMax(offlineQueries.get(i).x);
            ans[offlineQueries.get(i).index] = XOR;
        }
        return ans;
    }

    class Query{
        int x;
        int m;
        int index;

        public Query(int x, int m, int i){
            this.x=x;
            this.m=m;
            this.index=i;
        }
    }
}
