package com.stackandqueue;

import java.util.*;

//Next Smaller Element
//https://www.naukri.com/code360/problems/next-smaller-element_1112581?leftPanelTabValue=PROBLEM
public class NextSmallerElement {
    public class Solution{
        static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
            // Write your code here.
            int[] nse = new int[n];
            Stack<Integer> stack = new Stack<>();

            for(int i=n-1;i>=0;i--){
                while(!stack.isEmpty() && stack.peek() >= arr.get(i)) stack.pop();
                if(stack.isEmpty()) nse[i]=-1;
                else nse[i]= stack.peek();
                stack.push(arr.get(i));
            }
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i : nse) ans.add(i);
            return ans;
        }
    }
}
