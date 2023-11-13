package com.heaps;

import java.util.*;

//692. Top K Frequent Words
//https://leetcode.com/problems/top-k-frequent-words/description/
public class TopKFrequentWords {
    //Optimal sol using maxHeap
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Word> maxHeap = new PriorityQueue<>((w1, w2)->{
            int diff = w2.freq-w1.freq;
            if(diff < 0) return -1;
            if(diff > 0) return 1;
            return w1.s.compareTo(w2.s);
        });
        Map<String,Integer> freqMap = new HashMap<>();
        for(String s : words){
            freqMap.put(s, freqMap.getOrDefault(s, 0)+1);
        }

        for(String key : freqMap.keySet()){
            maxHeap.add(new Word(key, freqMap.get(key)));
        }

        List<String> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(maxHeap.poll().s);
        }
        return ans;
    }

    public class Word{
        String s;
        int freq;

        public Word(String s, int f){
            this.s = s;
            this.freq = f;
        }
    }
}
