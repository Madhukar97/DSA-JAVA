package com.bitmanipulation;

//2433. Find The Original Array of Prefix Xor
//https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
public class FindTheOriginalArrayOfPrefixXor {
    //Better sol with TC = O(n) and SC = O(n)
    public int[] findArray(int[] pref) {
        int[] ans = new int[pref.length];
        ans[0] = pref[0];

        for(int i=1;i<pref.length;i++){
            ans[i] = pref[i-1]^pref[i];
        }
        return ans;
    }

    //Optimal sol using TC = O(n) and SC = O(1)
    public int[] findArraySol2(int[] pref) {
        for(int i=pref.length-1;i>0;i--){
            pref[i] = pref[i-1]^pref[i];
        }
        return pref;
    }
}
