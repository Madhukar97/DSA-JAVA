package com.codestudio.arrays;

import java.util.*;

//Subarrays with XOR ‘K’
//https://www.codingninjas.com/studio/problems/subarrays-with-xor-k_6826258?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class SubarraysWithXORK {
    //optimal sol using hashing with time O(n) and space O(n)
    public static int subarraysWithSumK(int []a, int b) {
        int count=0;
        int xor=0;
        Map<Integer,Integer> prefixXor = new HashMap<>();

        for(int i=0;i<a.length;i++){
            xor=xor^a[i];
            if(xor == b) count++;
            if(prefixXor.containsKey(b^xor)) count+=prefixXor.get(b^xor);
            prefixXor.put(xor, prefixXor.getOrDefault(xor,0)+1);
        }
        return count;
    }
}
