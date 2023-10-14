package com.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

//225. Implement Stack using Queues
//
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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

    //Sol 2
class MyStack2 {
    Queue<Integer> queue;


    public MyStack2() {
        queue= new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++){
            queue.add(queue.poll());
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
