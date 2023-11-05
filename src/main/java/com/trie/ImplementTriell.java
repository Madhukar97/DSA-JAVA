package com.trie;

//Implement Trie ll
//https://www.codingninjas.com/studio/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=0
public class ImplementTriell {

    Node root;

    public ImplementTriell() {
        root = new Node();
    }

    public void insert(String word) {
        Node pointer = root;
        for(int i=0;i<word.length();i++){
            if(!pointer.contains(word.charAt(i))){
                pointer.put(word.charAt(i), new Node());
            }
            pointer = pointer.get(word.charAt(i));
            pointer.increasePrefix();
        }
        pointer.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        Node pointer = root;
        for(int i=0;i<word.length();i++){
            if(!pointer.contains(word.charAt(i))){
                return 0;
            }
            pointer = pointer.get(word.charAt(i));
        }
        return pointer.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node pointer = root;
        for(int i=0;i<word.length();i++){
            if(!pointer.contains(word.charAt(i))){
                return 0;
            }
            pointer = pointer.get(word.charAt(i));
        }
        return pointer.getPrefix();
    }

    public void erase(String word) {
        Node pointer = root;
        for(int i=0;i<word.length();i++){
            pointer = pointer.get(word.charAt(i));
            pointer.decreasePrefix();
        }
        pointer.decreaseEnd();
    }

    class Node{
        Node[] links = new Node[26];
        int prefixCount=0;
        int endCount=0;

        public boolean contains(char ch){
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node){
            links[ch -'a'] = node;
        }

        public Node get(char ch){
            return links[ch - 'a'];
        }

        public void increasePrefix(){
            prefixCount++;
        }

        public void increaseEnd(){
            endCount++;
        }

        public void decreasePrefix(){
            prefixCount--;
        }

        public void decreaseEnd(){
            endCount--;
        }

        public int getPrefix(){
            return prefixCount;
        }

        public int getEnd(){
            return endCount;
        }
    }
}
