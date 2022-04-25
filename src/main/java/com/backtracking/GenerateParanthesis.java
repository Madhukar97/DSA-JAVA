package com.backtracking;

import java.util.ArrayList;
import java.util.List;

//22. Generate Parentheses
//https://leetcode.com/problems/generate-parentheses/
public class GenerateParanthesis {
    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }

    static void generate(List<String> res, String str, int open, int close, int n) {
        if(str.length() == 2*n) {
            res.add(str);
        }

        if(open < n) {
            generate(res, str + "(", open+1, close, n);
        }
        if(close < open) {
            generate(res, str + ")", open, close+1, n);
        }
    }
}
