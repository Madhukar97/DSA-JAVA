package com.trie;

//208. Implement Trie (Prefix Tree)
//https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class ImplementTriePrefixTree {
    Node root;

    public ImplementTriePrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node pointer = root;
        for(int i=0;i<word.length();i++){
            if(!pointer.contains(word.charAt(i))){
                pointer.put(word.charAt(i), new Node());
            }
            pointer = pointer.get(word.charAt(i));
        }
        pointer.setEnd();
    }

    public boolean search(String word) {
        Node pointer = root;
        for(int i=0;i<word.length();i++){
            if(!pointer.contains(word.charAt(i))){
                return false;
            }
            pointer = pointer.get(word.charAt(i));
        }
        return pointer.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node pointer = root;
        for(int i=0;i<prefix.length();i++){
            if(!pointer.contains(prefix.charAt(i))){
                return false;
            }
            pointer = pointer.get(prefix.charAt(i));
        }
        return true;
    }

    class Node{
        Node[] links = new Node[26];
        boolean flag;

        public boolean contains(char ch){
            return links[ch - 'a'] != null;
        }

        public Node get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            flag = true;
        }

        public boolean isEnd(){
            return flag;
        }
    }
}
