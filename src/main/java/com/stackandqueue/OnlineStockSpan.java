package com.stackandqueue;

import java.util.Stack;

//901. Online Stock Span
//https://leetcode.com/problems/online-stock-span/description/
public class OnlineStockSpan {
    // Better sol using stacks
    class StockSpanner {
        Stack<Integer> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            Stack<Integer> temp = new Stack<>();
            while(!stack.isEmpty() && stack.peek() <= price) temp.push(stack.pop());
            int ans = temp.size()+1;
            while(!temp.isEmpty()) stack.add(temp.pop());
            stack.add(price);
            return ans;
        }
    }
    // Optimal sol
    class StockSpanner2 {
        Stack<Node> stack;
        int count=0;

        public StockSpanner2() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int prev=-1;
            while(!stack.isEmpty() && stack.peek().val <= price) stack.pop();
            if(!stack.isEmpty()) prev = stack.peek().index;
            stack.push(new Node(price, count));
            count++;
            return stack.peek().index-prev;
        }

        class Node{
            int val;
            int index;
            public Node(int v, int i){
                val=v;
                index=i;
            }
        }
    }
}
