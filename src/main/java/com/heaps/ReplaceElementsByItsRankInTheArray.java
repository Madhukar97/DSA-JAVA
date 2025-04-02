package com.heaps;

import java.util.PriorityQueue;

//Replace elements by its rank in the array
//https://www.geeksforgeeks.org/problems/replace-elements-by-its-rank-in-the-array/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-elements-by-its-rank-in-the-array
public class ReplaceElementsByItsRankInTheArray {
    class Solution {
        static int[] replaceWithRank(int arr[], int N) {
            // code here
            PriorityQueue<Item> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
            for(int i=0;i<N;i++) pq.add(new Item(i, arr[i]));
            int[] ans = new int[N];
            int rank=1;
            Item prevItem = pq.peek();
            while(!pq.isEmpty()){
                Item curr = pq.poll();
                if(curr.val != prevItem.val) {
                    rank++;
                    prevItem = curr;
                }
                ans[curr.index] = rank;
            }
            return ans;
        }

        static class Item{
            int index;
            int val;
            public Item(int i, int v){
                index=i;
                val=v;
            }
        }
    }
}
