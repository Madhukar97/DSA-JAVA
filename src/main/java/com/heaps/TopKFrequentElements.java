package com.heaps;

import java.util.*;

//347. Top K Frequent Elements
//https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2)->e2.freq-e1.freq);
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }

        for(int key : map.keySet()){
            pq.add(new Element(key, map.get(key)));
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().val;
        }
        return ans;
    }

    class Element{
        int val;
        int freq;

        public Element(int v, int f){
            this.val=v;
            this.freq=f;
        }
    }

    // Revision 5
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2) -> a1[1]-a2[1]);
            for(int key : map.keySet()) {
                pq.add(new int[]{key, map.get(key)});
                if(pq.size() > k) pq.poll();
            }
            int[] ans = new int[k];
            for(int i=0;i<k;i++) ans[i] = pq.poll()[0];
            return ans;
        }
    }
}
