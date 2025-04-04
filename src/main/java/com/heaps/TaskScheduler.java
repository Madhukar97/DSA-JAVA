package com.heaps;

import java.util.*;

//621. Task Scheduler
//https://leetcode.com/problems/task-scheduler/description/
public class TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] chars = new int[26];
            for(char ch : tasks) chars[ch-'A']++;
            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)-> n2.count-n1.count);
            for(int i=0;i<26;i++) if(chars[i] > 0) pq.add(new Node((char)((int)'A'+i), chars[i], 1));

            Queue<Node> q = new LinkedList<>();
            int time=1;
            int count=0;
            String ans = "";
            while(!pq.isEmpty() || !q.isEmpty()){
                if(!q.isEmpty() && q.peek().time == time) {
                    Node curr = q.poll();
                    pq.add(new Node(curr.ch, curr.count, curr.time));
                }
                if(!pq.isEmpty()){
                    Node curr = pq.poll();
                    ans += curr.ch;
                    if(curr.count > 1) q.add(new Node(curr.ch, curr.count-1, time+n+1));
                }else{
                    ans+= "_";
                }
                time++;
                count++;
            }
            // System.out.println("ANS : " + ans);
            return count;
        }
        class Node {
            char ch;
            int count;
            int time;
            public Node(char ch, int c, int t){
                this.ch=ch;
                count=c;
                time=t;
            }
        }
    }
}
