package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

//60. Permutation Sequence
//https://leetcode.com/problems/permutation-sequence/description/
public class PermutationSequence {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.remove(1);
        list.remove((Integer) 3);
        System.out.println("LIST : " + list);
    }
    //Brute force sol, generate all permutations and return kth, time O(n!) and space O(n + n!)
    public String getPermutation(int n, int k) {
        String s = "";
        for(int i=1;i<=n;i++) s+= i;
        List<String> ans = new ArrayList<>();
        // System.out.println("String : " + s);
        recFunc(s, 0, "", ans);
        return ans.get(k-1);
    }

    public void recFunc(String s, int i, String permutation, List<String> ans){
        if( i >= s.length()){
            if(s.length()==0){
                // System.out.println("perm : " + permutation);
                ans.add(permutation);
            }
            return;
        }

        //pick
        recFunc(s.substring(0,i)+s.substring(i+1), 0, permutation + s.charAt(i), ans);
        //not pick
        recFunc(s,i+1,permutation,ans);
    }

    //Most Optimal sol with time O(n^2) and space O(n)
    public String getPermutationSol2(int n, int k) {
        String s = "";
        k=k-1; //convert to 0 based indexing
        List<Integer> arr = new ArrayList<>();
        for(int i=1;i<=n;i++) arr.add(i);
        int fact=1;
        for(int i=1;i<n;i++){
            fact=fact*i;
        }

        while(true){
            // System.out.println("K : " + k);
            // System.out.println("fact : " + fact);
            // System.out.println("arr : " + arr);
            s+=arr.get(k/fact); // index of required permutation
            arr.remove(k/fact);
            if(arr.size()==0) break;
            k=k%fact;   //remaining required permutation
            fact=fact/(arr.size());     //total remaining permutations
            // System.out.println("after remove arr : " + arr);
        }
        // System.out.println("final arr : " + arr);
        return s;
    }
}
