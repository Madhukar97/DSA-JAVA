package com.stackandqueue;

import java.util.HashMap;
import java.util.Map;

//146. LRU Cache
//https://leetcode.com/problems/lru-cache/description/
public class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
            insert(curr);
            return curr.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }else if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    public void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insert(Node node){
        map.put(node.key, node);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    class Node{
        Node next;
        Node prev;
        int key;
        int val;

        Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
}
