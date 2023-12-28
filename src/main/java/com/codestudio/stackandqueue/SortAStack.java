package com.codestudio.stackandqueue;

import java.util.Stack;

//Sort a Stack
//https://www.codingninjas.com/studio/problems/sort-a-stack_985275?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class SortAStack {
    //Sol using recursion
    public static void sortStack(Stack<Integer> stack) {
        if(stack.isEmpty()) return;
        int top = stack.pop();

        sortStack(stack);

        if(stack.isEmpty()){
            stack.push(top);
        }else{
            Stack<Integer> temp = new Stack<>();
            while(!stack.isEmpty() && stack.peek() > top){
                temp.push(stack.pop());
            }
            stack.push(top);
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }
        }
    }

    //Revision 2
    public class Solution {

        public static void sortStack(Stack<Integer> stack) {
            int prev = stack.pop();
            if(!stack.isEmpty()){
                sortStack(stack);
            }

            if(stack.isEmpty()) stack.add(prev);
            else{
                Stack<Integer> temp = new Stack<>();
                while(!stack.isEmpty() && stack.peek() > prev) temp.add(stack.pop());
                stack.add(prev);
                while(!temp.isEmpty()) stack.add(temp.pop());
            }
        }

    }
}
