package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

//131. Palindrome Partitioning
//https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "asdf";
        System.out.println(s.substring(1));
        s.substring(1,2);
    }
    //Most optimal sol
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> subStringList = new ArrayList<>();
        recFunc(s, 0, subStringList, ans);
        return ans;
    }

    public void recFunc(String s, int ind, List<String> subStringList, List<List<String>> ans){
        if(ind >= s.length()) {
            List<String> subStrings = new ArrayList<>(subStringList);
            ans.add(subStrings);
            return;
        }

        //pick
        for(int i=ind;i<s.length();i++){
            if(checkIfPalindrome(s, ind, i)){
                String sub = s.substring(0,i+1);
                subStringList.add(sub);
                recFunc(s.substring(i+1),0,subStringList,ans);
                subStringList.remove(subStringList.size()-1);
            }
        }

    }

    public boolean checkIfPalindrome(String str, int s, int e){
        while(s <= e){
            if(str.charAt(s) != str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}
