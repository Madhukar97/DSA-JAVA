package com.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Non-Repeating Element
//https://practice.geeksforgeeks.org/problems/non-repeating-element3958/1/#
public class NonRepeatingElement {
    public static void main(String[] args) {

    }
    public int firstNonRepeating(int arr[], int n)
    {
        // Complete the function
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            if(map.containsKey(num)) map.remove(num);
            else map.put(num, 0);
        }
        int ans = (int)map.values().toArray()[0];
        return ans;
    }

}
