package com.codestudio.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

//Implement Stack using Queues
//https://leetcode.com/problems/implement-stack-using-queues/
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.remove();
        queue.size();
        queue.peek();
        queue.poll();
        queue.isEmpty();
    }

    class MyStack {
        Queue<Integer> queue;


        public MyStack() {
            queue= new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            for(int i=0;i<queue.size()-1;i++){
                int element = queue.remove();
                queue.add(element);
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
