package com.graphs;

import java.util.*;

//10033. Minimum Number of Operations to Make X and Y Equal
//https://leetcode.com/problems/minimum-number-of-operations-to-make-x-and-y-equal/
public class MinimumNumberOfOperationsToMakeXAndYEqual {
    //Sol using Dijkstras algo
    class Solution {
        public int minimumOperationsToMakeEqual(int x, int y) {
            if(x==y) return 0;
            if(x < y) return y-x;

            Queue<Node> pq = new LinkedList<>();
            pq.add(new Node(x, 0));
            Set<Integer> set = new HashSet<>();

            while(!pq.isEmpty()){
                Node node = pq.poll();
                int num = node.num;
                int ops = node.ops;

                if(num == y) return ops;

                if(num%11 == 0 && !set.contains(num/11)){
                    int newNum = num/11;
                    pq.add(new Node(newNum, ops+1));
                    set.add(newNum);
                }
                if(num%5 == 0 && !set.contains(num/5)){
                    int newNum = num/5;
                    pq.add(new Node(newNum, ops+1));
                    set.add(newNum);
                }
                if(!set.contains(num+1)){
                    pq.add(new Node(num+1, ops+1));
                    set.add(num+1);
                }
                if(!set.contains(num-1)){
                    pq.add(new Node(num-1, ops+1));
                    set.add(num-1);
                }
            }
            return 0;
        }

        public class Node{
            int num;
            int ops;

            public Node(int a, int o){
                num=a;
                ops=o;
            }
        }
    }
}
