package com.heaps;

import java.util.*;

//Merge K Sorted Arrays
//https://www.codingninjas.com/studio/problems/merge-k-sorted-arrays_975379?leftPanelTab=0
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
}
