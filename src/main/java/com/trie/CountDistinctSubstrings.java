package com.trie;

//Count Distinct Substrings
//https://www.codingninjas.com/studio/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0
public class CountDistinctSubstrings {
    public static int countDistinctSubstrings(String s) {
        Node root = new Node();
        int n = s.length();
        int count = 0;

        for(int i=0;i<n;i++){
            Node pointer = root;
            for(int j=i;j<n;j++){
                if(!pointer.contains(s.charAt(j))){
                    count++;
                    pointer.put(s.charAt(j), new Node());
                }
                pointer = pointer.get(s.charAt(j));
            }
        }
        return count+1;
    }

    static class Node{
        Node[] links = new Node[26];

        public boolean contains(char ch){
            return links[ch - 'a'] != null;
        }

        public Node get(char ch){
            return links[ch-'a'];
        }

        public void put(char ch, Node node){
            links[ch - 'a'] = node;
        }
    }
}
