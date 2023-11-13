package com.heaps;

import java.util.*;

//2284. Sender With Largest Word Count
//https://leetcode.com/problems/sender-with-largest-word-count/description/
public class SenderWithLargestWordCount {
    // Optimal sol using maxHeap
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> countMap = new HashMap<>();
        for(int i=0;i<senders.length;i++){
            String[] words = messages[i].split(" ");
            countMap.put(senders[i], countMap.getOrDefault(senders[i], 0) + words.length);
        }

        PriorityQueue<Sender> maxHeap = new PriorityQueue<>((s1,s2)->{
            int diff = s2.count-s1.count;
            if(diff < 0) return -1;
            else if(diff > 0) return 1;
            return s2.name.compareTo(s1.name);
        });

        for(String key : countMap.keySet()){
            maxHeap.add(new Sender(key, countMap.get(key)));
        }

        return maxHeap.poll().name;
    }

    public class Sender{
        String name;
        int count;

        public Sender(String name, int c){
            this.name=name;
            this.count=c;
        }
    }
}
