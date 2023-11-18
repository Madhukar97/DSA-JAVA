package com.backtracking;

import java.util.*;

//140. Word Break II
//https://leetcode.com/problems/word-break-ii/description/
public class WordBreakII {
    //Brute force sol using recursion
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        rec(s, 0, wordDict, ans, "");
        return ans;
    }

    public void rec(String s, int index, List<String> dict, List<String> ans, String sentence){
        if(index == s.length()){
            ans.add(sentence);
            return;
        }

        for(int i=index;i<s.length();i++){
            if(dict.contains(s.substring(index, i+1))){
                String newSentence = sentence;
                if(index > 0) newSentence = newSentence + " " + s.substring(index, i+1);
                else newSentence = s.substring(0, i+1);
                rec(s, i+1, dict, ans, newSentence);
            }
        }
    }
}
