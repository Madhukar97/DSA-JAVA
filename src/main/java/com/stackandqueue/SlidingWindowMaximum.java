package com.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

//239. Sliding Window Maximum
//https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {
    //Optimal sol using time O(n+n) and space O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] msw = new int[n-k+1];
        int mi=0;

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            //remove out of range indexes
            if(!deque.isEmpty() && deque.peek() <= i-k){
                deque.poll();
            }

            //remove smaller elements
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            deque.offer(i);
            if(i >= k-1) msw[mi++] = nums[deque.peek()];
        }
        return msw;
    }
}
