package com.codestudio.backtracking;

import java.util.ArrayList;

//Word Break II
//https://www.codingninjas.com/studio/problems/983635?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=PROBLEM
public class WordBreakII {
    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> ans = new ArrayList<>();
        recFunc(s, dictionary, 0, "", ans);
        return ans;
    }

    public static void recFunc(String s, ArrayList<String> dictionary, int ind, String sub, ArrayList<String> ans){
        if(ind == s.length()){
            ans.add(sub);
            return;
        }

        for(int j=ind;j<s.length();j++){
            if(isPresent(s, ind, j, dictionary)){
                if(sub.length() > 0) recFunc(s.substring(j+1), dictionary, 0, sub+" "+s.substring(0,j+1), ans);
                else recFunc(s.substring(j+1), dictionary, 0, s.substring(0,j+1), ans);
            }
        }
    }

    public static boolean isPresent(String s, int i, int j, ArrayList<String> dictionary){
        String str = s.substring(i,j+1);
        return dictionary.contains(str);
    }
}
