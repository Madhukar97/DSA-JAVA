package com.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0)  return ans;
        Map<String,String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        recFunc(digits, map, 0, ans, "");
        return ans;
    }

    void recFunc(String digits, Map<String,String> map, int index, List<String> ans, String pros) {
        if(index == digits.length()) {
            ans.add(pros);
            return;
        }

        String digit = digits.substring(index,index+1);
        for(int i=0; i<map.get(digit).length(); i++ ){
            recFunc(digits, map, index+1, ans, pros+map.get(digit).charAt(i));
        }


    }
}
