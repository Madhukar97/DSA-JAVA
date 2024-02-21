package com.strings;

import java.util.*;

//49. Group Anagrams
//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<Integer>> map = new HashMap<>();
        int i=0;
        for(String s : strs){
            List<Character> list = new ArrayList<>();
            for(int j=0;j<s.length();j++) list.add(s.charAt(j));
            Collections.sort(list);
            if(map.containsKey(list)){
                map.get(list).add(i);
            }else{
                List<Integer> list2 = new ArrayList<>();
                list2.add(i);
                map.put(list, list2);
            }
            i++;
        }

        List<List<String>> ans = new ArrayList<>();
        for(List<Character> key : map.keySet()){
            List<Integer> list = map.get(key);
            List<String> words = new ArrayList<>();
            for(int index : list) words.add(strs[index]);
            ans.add(words);
        }
        return ans;
    }
}
