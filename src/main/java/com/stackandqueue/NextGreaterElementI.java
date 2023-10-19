package com.stackandqueue;

import java.util.HashMap;
import java.util.Stack;

//496. Next Greater Element I
//https://leetcode.com/problems/next-greater-element-i/description/
public class NextGreaterElementI {
    //Brute force
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length];
        for (int i = 0; i < nums3.length ; i++) {
            nums3[i] =  findNextMaxNum(nums2 , nums1[i]);
        }
        return nums3;
    }
    public static int findNextMaxNum(int[] arr , int n ) {
        int temp = -1 ;
        for (int i = 0 ; i < arr.length ; i++) {
            if (arr[i] == n) {
                while ((i + 1) < arr.length && temp <= n) {
                    i++;
                    temp = Math.max(n, arr[i]);
                }
                break;
            }
        }
        return (temp == n) ? -1 : temp ;
    }

    //Optimal sol using stack and hashmap with time O(n1+n2) and space O(n1 + n2)
    public int[] nextGreaterElementSol2(int[] nums1, int[] nums2) {
        int[] nge = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i] = -1;
            }else{
                nge[i] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i], nge[i]);
        }

        int[] ans = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
