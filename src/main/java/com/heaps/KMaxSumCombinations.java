package com.heaps;

import java.util.PriorityQueue;

//K Max Sum Combinations
//https://www.codingninjas.com/studio/problems/k-max-sum-combinations_975322?leftPanelTabValue=PROBLEM
public class KMaxSumCombinations {
    //Optimal sol using maxHeap
    public static int[] kMaxSumCombination(int []A, int []B, int n, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2)->o2-o1);

        for(int a : A){
            for(int b : B){
                maxHeap.add(a+b);
            }
        }

        int[] ans = new int[k];
        for(int i=0;i<k;i++) ans[i] = maxHeap.poll();
        return ans;
    }
}
