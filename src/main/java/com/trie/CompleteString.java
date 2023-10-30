package com.trie;

//Complete String
//Longest String with all prefixes
public class CompleteString {
    public static String completeString(int n, String[] a) {
        Trie trie = new Trie();
        String ans = "";
        for(String s : a) trie.insert(s);

        for(String s : a){
            if(trie.checkIfAllPrefixExists(s)){
                if(s.length() > ans.length()){
                    ans = s;
                }else if(s.length() == ans.length() && s.compareTo(ans) < 0){
                    ans = s;
                }
            }
        }
        if(ans == "") return "None";
        return ans;
    }

    static class Node{
        Node[] links = new Node[26];
        boolean flag;

        public boolean contains(char ch){
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        public Node get(char ch){
            return links[ch - 'a'];
        }

        public void setEnd(){
            flag = true;
        }

        public boolean getEnd(){
            return flag;
        }
    }

    static class Trie{
        Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(String word){
            Node pointer = root;
            for(int i=0;i<word.length();i++){
                if(!pointer.contains(word.charAt(i))){
                    pointer.put(word.charAt(i), new Node());
                }
                pointer = pointer.get(word.charAt(i));
            }
            pointer.setEnd();
        }

        public boolean checkIfAllPrefixExists(String word){
            Node pointer = root;
            for(int i=0;i<word.length();i++){
                if(!pointer.contains(word.charAt(i))) return false;
                pointer = pointer.get(word.charAt(i));
                if(!pointer.getEnd()) return false;
            }
            return true;
        }
    }
}
