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
        stack.get(0);
    }
    // sol with time O(n) ans space O(1) : Not Valid cannot use remove method
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
    //Optimal sol with time O(1) ans space O(1) : Not Valid cannot use remove method
    class MyQueue2 {
        Stack<Integer> stack;

        public MyQueue2() {
            stack=new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
        }

        public int pop() {
            return stack.remove(0);
        }

        public int peek() {
            return stack.get(0);
        }

        public boolean empty() {
            return stack.isEmpty();
        }
    }
    //Only acceptable optimal sol using 2 stacks with time O(1) amortized
    class MyQueue3 {
        Stack<Integer> first;
        Stack<Integer> second;
        public MyQueue3()
        {
            first = new Stack<>();
            second = new Stack<>();
        }
        public void push(int x)
        {
            first.push(x);
        }

        // first pop it from first stack and push into second stack,
        // then pop the element from second stack and again pop
        // it from second stack and push in first stack
        public int pop()
        {
            while(!first.isEmpty())
                second.push(first.pop());

            int removed = second.pop();

            while(!second.isEmpty())
                first.push(second.pop());

            return removed;
        }
        // same thing in peek as pop
        public int peek()
        {
            while(! first.isEmpty())
                second.push(first.pop());

            int peeked= second.peek();

            while(!second.isEmpty())
                first.push(second.pop());

            return peeked;
        }

        public boolean empty()
        {
            return first.isEmpty();
        }
    }

    //Revision 2
    class MyQueueR2 {
        Stack<Integer> s1;

        public MyQueueR2() {
            this.s1 = new Stack<>();
        }

        public void push(int x) {
            Stack<Integer> s2 = new Stack<>();
            while(!s1.isEmpty()) s2.push(s1.pop());
            s1.add(x);
            while(!s2.isEmpty()) s1.add(s2.pop());
        }

        public int pop() {
            if(s1.isEmpty()) return -1;
            return s1.pop();
        }

        public int peek() {
            if(s1.isEmpty()) return -1;
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }


}
