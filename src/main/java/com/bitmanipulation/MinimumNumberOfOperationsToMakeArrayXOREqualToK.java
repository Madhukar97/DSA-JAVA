package com.bitmanipulation;

import java.util.*;

//10032. Minimum Number of Operations to Make Array XOR Equal to K
//https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/
public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    //Optimal sol
    //XOR all of nums and k, and count the 1 bits
    class Solution {
        public int minOperations(int[] nums, int k) {
            int xor=0;
            for(int i : nums ) xor^=i;
            xor^=k;
            String bits = Integer.toBinaryString(xor);
            int ones = 0;
            for(int i=0;i<bits.length();i++) if(bits.charAt(i) == '1') ones++;
            return ones;
        }
    }

    //Better sol using Dijkstras algo
    //Getting TLE
    class Solution2 {
        public int minOperations(int[] nums, int k) {
            int numsXOR = 0;
            for(int i : nums) numsXOR^=i;
            if(k==numsXOR) return 0;

            int maxLen = Integer.toBinaryString(k).length();

            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->n1.ops-n2.ops);
            pq.add(new Node(nums.clone(), 0, numsXOR));
            Set<Integer> set = new HashSet<>();
            set.add(numsXOR);

            while(!pq.isEmpty()){
                Node node = pq.poll();
                int[] arr = node.arr;
                int ops = node.ops;
                int xor = node.xor;

                if(xor == k) return ops;

                for(int i=0;i<arr.length;i++){
                    String bits = Integer.toBinaryString(arr[i]);
                    if(bits.length() < 32 && bits.length() < maxLen) {
                        StringBuilder dummy = new StringBuilder();
                        for(int c=0;c<maxLen-bits.length();c++) dummy.append("0");
                        bits = dummy.toString() + bits;
                    }
                    for(int j=0;j<bits.length();j++){
                        char bit = bits.charAt(j);
                        char replacebit = bit=='1'? '0' : '1';
                        StringBuilder sb = new StringBuilder();
                        sb.append(bits.substring(0,j)).append(replacebit);
                        if(j<bits.length()-1) sb.append(bits.substring(j+1, bits.length()));

                        // String newBits = bits.substring(0,j) + replacebit;
                        // if(j<bits.length()-1) newBits+=bits.substring(j+1, bits.length());
                        // int newNum = Integer.parseInt(newBits, 2);
                        int newNum = Integer.parseInt(sb.toString(), 2);
                        int[] newArr = arr.clone();
                        newArr[i] = newNum;
                        int newXor = xor^arr[i]^newNum;
                        if(!set.contains(newXor)) pq.add(new Node(newArr, ops+1, newXor));
                    }
                }
            }
            return 0;
        }

        public class Node{
            int[] arr;
            int ops;
            int xor;

            public Node(int[] a, int o, int x){
                arr=a;
                ops=o;
                xor=x;
            }
        }
    }
}
