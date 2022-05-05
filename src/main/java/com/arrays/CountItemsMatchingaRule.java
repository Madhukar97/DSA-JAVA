package com.arrays;

import java.util.List;

//1773. Count Items Matching a Rule
//https://leetcode.com/problems/count-items-matching-a-rule/
public class CountItemsMatchingaRule {
    public static void main(String[] args) {

    }
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        switch (ruleKey) {
            case "type" :
                index = 0;
                break;
            case "color" :
                index = 1;
                break;
            default:  index = 2;
        }
        int count = 0;
        for(List<String> item : items) {
            if(item.get(index).equals(ruleValue)) count++;
        }
        return count;
    }
}
