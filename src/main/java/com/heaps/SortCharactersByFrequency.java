package com.heaps;

import java.util.*;

//451. Sort Characters By Frequency
//https://leetcode.com/problems/sort-characters-by-frequency/description/
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->n2.freq-n1.freq);
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for(char key : map.keySet()){
            pq.add(new Node(key, map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(int i=0;i<node.freq;i++){
                sb.append(node.ch);
            }
        }
        return sb.toString();
    }

    class Node{
        char ch;
        int freq;

        public Node(char ch, int f){
            this.ch=ch;
            this.freq=f;
        }
    }
}
