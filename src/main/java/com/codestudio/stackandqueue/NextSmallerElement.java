package com.codestudio.stackandqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Next Smaller Element
//https://www.codingninjas.com/studio/problems/next-smaller-element_1112581?leftPanelTab=0
public class NextSmallerElement {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.
    }
    //Optimal sol using stack with time O(n) and space O(2n)
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i]=-1;
            }else{
                nse[i]=stack.peek();
            }
            stack.push(arr.get(i));
        }
        for(int i: nse){
            ans.add(i);
        }
        return ans;
    }
    //Most Optimal sol using stack with time O(n) and space O(n)
    static ArrayList<Integer> nextSmallerElementSol2(ArrayList<Integer> arr, int n){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(stack.peek());
            }
            stack.push(arr.get(i));
        }
        for(int i=0;i<n/2;i++){
            int temp=ans.get(i);
            ans.set(i, ans.get(n-i-1));
            ans.set(n-i-1, temp);
        }
        return ans;
    }
}
