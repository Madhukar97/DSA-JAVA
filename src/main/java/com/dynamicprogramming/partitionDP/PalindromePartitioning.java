package com.dynamicprogramming.partitionDP;

import java.util.ArrayList;
import java.util.List;

//131. Palindrome Partitioning
//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public static void main(String[] args) {

    }
    List<String> inner = new ArrayList<>();

    public List<List<String>> partition(String s) {
        List<List<String>> outer = new ArrayList<>();
        dfs(0, outer, new ArrayList<String>(), s);
        //recFunc("", s);
        return outer;
    }

    // Method for getting all possible permutations
//     void recFunc(String pross, String source) {
//         if(source.length() == 0 ){
//             boolean b = isPalindrome(pross, 0, pross.length()-1);
//             if(pross.length() != 0 && b) inner.add(pross);
//             System.out.println(pross);
//             return;
//         }

//         recFunc(pross+source.charAt(0), source.substring(1));

//         recFunc(pross, source.substring(1));
//     }

    void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length()) result.add(new ArrayList<String>(currentList));
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    boolean isPalindrome(String pross, int s, int e) {
        while(s<e){
            if(pross.charAt(s++) != pross.charAt(e--)) return false;
        }
        return true;
    }

    //Revision 2
    public List<List<String>> partitionR2(String s) {
        List<List<String>> ans = new ArrayList<>();
        rec(s, 0, ans, new ArrayList<>());
        return ans;
    }

    public void rec(String s, int index, List<List<String>> ans, List<String> pals){
        if(index == s.length()){
            ans.add(new ArrayList<>(pals));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindromeR2(s, index, i)){
                pals.add(s.substring(index,i+1));
                rec(s, i+1, ans, pals);
                pals.remove(pals.size()-1);
            }
        }
    }

    public boolean isPalindromeR2(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
