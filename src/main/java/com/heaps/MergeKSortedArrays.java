package com.heaps;

import java.util.*;

//Merge K Sorted Arrays
//https://www.codingninjas.com/studio/problems/merge-k-sorted-arrays_975379?leftPanelTab=0
//https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=merge-k-sorted-arrays
public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
    {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(ArrayList<Integer> arr : kArrays){
            for(int n : arr){
                minHeap.add(n);
            }
        }

        while(!minHeap.isEmpty()) ans.add(minHeap.poll());
        return ans;
    }

    // Revision 5
    class Solution {
        public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) {
            ArrayList<Integer> ans = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int[] row : arr){
                for(int i : row) pq.add(i);
            }
            while(!pq.isEmpty()) ans.add(pq.poll());
            return ans;
        }
    }
}
