package com.stackandqueue;

import java.util.HashMap;
import java.util.Map;

//460. LFU Cache
//https://leetcode.com/problems/lfu-cache/description/
public class LFUCache {
    int capacity;
    int minFrequency;
    Map<Integer, DDLNode> cacheMap;
    Map<Integer, DoublyLinkedList> freqMap;


    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.minFrequency=0;
        this.cacheMap = new HashMap<>();
        this.freqMap =  new HashMap<>();
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)){
            DDLNode node = cacheMap.get(key);
            updateNode(node);
            return node.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(capacity == 0) return;
        if(cacheMap.containsKey(key)){
            DDLNode curr = cacheMap.get(key);
            curr.val=value;
            updateNode(curr);
        }
        else{
            if(cacheMap.size() == capacity){
                DoublyLinkedList minfreqList = freqMap.get(minFrequency);
                cacheMap.remove(minfreqList.tail.prev.key);
                minfreqList.remove(minfreqList.tail.prev);
            }
            minFrequency=1;
            DDLNode newNode = new DDLNode(key,value);
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.insert(newNode);
            freqMap.put(1, list);
            cacheMap.put(key, newNode);
        }
    }

    public void updateNode(DDLNode curr){
        int currFreq = curr.frequency;
        DoublyLinkedList list = freqMap.get(currFreq);
        list.remove(curr);
        if(currFreq == minFrequency && list.size == 0){
            minFrequency++;
        }
        curr.frequency++;
        DoublyLinkedList nextList = freqMap.getOrDefault(curr.frequency, new DoublyLinkedList());
        nextList.insert(curr);
        freqMap.put(curr.frequency, nextList);
    }

    class DDLNode{
        int key;
        int val;
        int frequency;
        DDLNode next;
        DDLNode prev;

        public DDLNode(int key, int val){
            this.key=key;
            this.val=val;
            this.frequency=1;
        }
    }

    class DoublyLinkedList{
        int size;
        DDLNode head;
        DDLNode tail;

        public DoublyLinkedList(){
            this.size=0;
            head = new DDLNode(0,0);
            tail = new DDLNode(0,0);
            head.next=tail;
            tail.prev=head;
        }

        public void insert(DDLNode curNode){
            DDLNode nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            size++;
        }

        public void remove(DDLNode curNode){
            DDLNode prevNode = curNode.prev;
            DDLNode nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            size--;
        }
    }
}
