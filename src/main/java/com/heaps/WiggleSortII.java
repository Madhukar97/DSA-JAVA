package com.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

//324. Wiggle Sort II
//https://leetcode.com/problems/wiggle-sort-ii/description/
public class WiggleSortII {
    //Better sol using maxHeap
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : nums) maxHeap1.add(i);

        for(int i=0;i<nums.length/2;i++){
            maxHeap2.add(maxHeap1.poll());
        }

        int i=0;
        while(!maxHeap1.isEmpty() && !maxHeap2.isEmpty()){
            if(i%2==0) {
                nums[i] = maxHeap1.poll();
            }else {
                nums[i] = maxHeap2.poll();
            }
            i++;
        }
        if(!maxHeap1.isEmpty()) nums[i] = maxHeap1.poll();
        if(!maxHeap2.isEmpty()) nums[i] = maxHeap2.poll();
    }
}
