package com.trie;

import java.util.HashMap;

//211. Design Add and Search Words Data Structure
//https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
public class DesignAddAndSearchWordsDataStructure {
    //Sol using Trie and Node with HashMap links
    Node root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new Node();
    }

    public void addWord(String word) {
        Node pointer = root;
        for(int i=0;i<word.length();i++){
            if(!pointer.links.containsKey(word.charAt(i))){
                pointer.links.put(word.charAt(i), new Node());
            }
            pointer = pointer.links.get(word.charAt(i));
        }
        pointer.setEnd();
    }

    public boolean search(String word) {
        return dfs(0, root, word);
    }

    public boolean dfs(int index, Node node, String word){
        Node pointer = node;
        for(int i=index;i<word.length();i++){
            if(word.charAt(i) == '.'){
                for(Node n : pointer.links.values()){
                    if(dfs(i + 1, n, word)) return true;
                }
                return false;
            }else {
                if(!pointer.links.containsKey(word.charAt(i))) return false;
                pointer = pointer.links.get(word.charAt(i));
            }
        }
        return pointer.isEnd();
    }

    class Node{
        HashMap<Character, Node> links = new HashMap<>();
        boolean flag;

        public void setEnd(){
            flag = true;
        }

        public boolean isEnd(){
            return flag;
        }
    }
}
