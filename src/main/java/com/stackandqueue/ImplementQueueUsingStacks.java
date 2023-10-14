package com.stackandqueue;

import java.util.Stack;

//232. Implement Queue using Stacks
//https://leetcode.com/problems/implement-queue-using-stacks/description/
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.pop();
        stack.remove(3);
        stack.isEmpty();
        stack.peek();
        stack.add(1);
        stack.size();
    }
    class MyQueue {
        Stack<Integer> stack;

        public MyQueue() {
            stack=new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
            for(int i=0;i<stack.size()-1;i++){
                stack.add(stack.remove(0));
            }
        }

        public int pop() {
            return stack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
