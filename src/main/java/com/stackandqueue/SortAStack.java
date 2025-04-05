package com.stackandqueue;

import java.util.Stack;

//Sort a Stack
//https://www.naukri.com/code360/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM
public class SortAStack {
    public class Solution {

        public static void sortStack(Stack<Integer> stack) {
            // Write your code here.
            int curr = stack.pop();
            if(!stack.isEmpty()) sortStack(stack);

            Stack<Integer> temp = new Stack<>();
            while(!stack.isEmpty() && stack.peek() > curr) temp.push(stack.pop());
            stack.push(curr);
            while(!temp.isEmpty()) stack.push(temp.pop());
        }

    }
}
