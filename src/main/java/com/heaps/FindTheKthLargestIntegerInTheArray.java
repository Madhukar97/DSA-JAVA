package com.heaps;

import java.math.BigInteger;
import java.util.PriorityQueue;

//1985. Find the Kth Largest Integer in the Array
//https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/
public class FindTheKthLargestIntegerInTheArray {
    //optimal sol using maxHeap
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>((s1, s2)->{
            BigInteger b2 = new BigInteger(s2);
            BigInteger b1 = new BigInteger(s1);
            return b2.compareTo(b1);
        });
        for(String s : nums) maxHeap.add(s);

        for(int i=1;i<k;i++){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    //Most optimal sol using maxHeap
    public String kthLargestNumberSol2(String[] nums, int k) {
        PriorityQueue<BigInteger> maxHeap = new PriorityQueue<>((b1,b2)->b2.compareTo(b1));
        for(String s : nums) maxHeap.add(new BigInteger(s));

        for(int i=1;i<k;i++){
            maxHeap.poll();
        }
        return maxHeap.poll().toString();
    }

}
