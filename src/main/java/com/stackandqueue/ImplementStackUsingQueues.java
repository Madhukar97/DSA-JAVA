package com.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

//225. Implement Stack using Queues
//
public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);   //adds new element at end of queue
        queue.remove(); //removes head of queue
        queue.size();
        queue.peek();   //retrieves head of queue
        queue.poll();   //removes head of queue without exception
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

    // Revision 5
    class MyStack5 {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack5() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            int ans = -1;
            while(q1.size() > 1) q2.add(q1.poll());
            if(q1.size() == 1) ans = q1.poll();
            q1 = q2;
            q2 = new LinkedList<>();
            return ans;
        }

        public int top() {
            if(q1.isEmpty()) return -1;
            while(q1.size() > 1) q2.add(q1.poll());
            int ans = -1;
            if(q1.size() == 1) {
                ans = q1.peek();
                q2.add(q1.poll());
            }
            q1 = q2;
            q2 = new LinkedList<>();
            return ans;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
