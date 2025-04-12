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

    //Slightly better approach
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<List<Character>, List<String>> map = new HashMap<>();
        int i=0;
        for(String s : strs){
            List<Character> list = new ArrayList<>();
            for(int j=0;j<s.length();j++) list.add(s.charAt(j));
            Collections.sort(list);
            if(map.containsKey(list)){
                map.get(list).add(strs[i]);
            }else{
                List<String> list2 = new ArrayList<>();
                list2.add(strs[i]);
                map.put(list, list2);
            }
            i++;
        }
        List<List<String>> ans = new ArrayList<>();
        ans.addAll(map.values());
        return ans;
    }

    //Better sol using Hashing
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int i=0;
        for(String s : strs){
            String sign = getSignature(s);
            if(map.containsKey(sign)){
                map.get(sign).add(strs[i]);
            }else{
                List<String> list2 = new ArrayList<>();
                list2.add(strs[i]);
                map.put(sign, list2);
            }
            i++;
        }
        List<List<String>> ans = new ArrayList<>();
        // System.out.println("MAP : " + map.toString());
        ans.addAll(map.values());
        return ans;
    }

    public String getSignature(String s){
        int[] chars = new int[26];
        for(char c : s.toCharArray()) chars[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) if(chars[i] != 0) sb.append((char)('a'+i)).append(chars[i]);
        return sb.toString();
    }
}
