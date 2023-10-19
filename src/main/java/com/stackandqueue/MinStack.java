package com.stackandqueue;

import java.util.Stack;

//155. Min Stack
//https://leetcode.com/problems/min-stack/description/
//Optimal solution 1 using stack and Pair class with time O(1) and space O(2n)
public class MinStack {
    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }else{
            int min = stack.peek().min;
            stack.push(new Pair(val, Math.min(min,val)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    class Pair{
        int val;
        int min;

        public Pair(int val, int min){
            this.val=val;
            this.min=min;
        }
    }
}
//Optimal solution 2 using stack with time O(1) and space O(n)
class MinStackSol2 {
    Stack<Long> stack;
    Long min;

    public MinStackSol2() {
        this.stack = new Stack<>();
        this.min=Long.MAX_VALUE;
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long)val);
            min=(long)val;
        }else{
            if(val >= min){
                stack.push((long)val);
            }else{
                Long modified = 2*(long)val-min;
                stack.push(modified);
                min=(long)val;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        Long top = stack.pop();
        if(top < min){
            min=2*min-top;
        }
    }

    public int top() {
        Long top = stack.peek();
        if(top < min) return min.intValue();
        return top.intValue();
    }

    public int getMin() {
        return min.intValue();
    }
}

