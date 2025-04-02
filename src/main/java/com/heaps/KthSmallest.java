package com.heaps;

import java.util.PriorityQueue;

//Kth Smallest
//https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=kth-smallest-element
public class KthSmallest {
    class Solution {
        public static int kthSmallest(int[] arr, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int i : arr) minHeap.add(i);
            while(!minHeap.isEmpty()){
                k--;
                int ans = minHeap.poll();
                if(k==0) return ans;
            }
            return 0;
        }
    }
}
