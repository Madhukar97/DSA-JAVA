package com.dynamicprogramming;

import java.util.HashMap;

//953. Verifying an Alien Dictionary
//https://leetcode.com/problems/verifying-an-alien-dictionary/
public class VerifyAlienDictionary {
    public static void main(String[] args) {
        String[] words = {"word","world","row"};
        String[] words2 = {"hello","leetcode"};
        String order = "worldabcefghijkmnpqstuvxyz";
        String order2 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
        System.out.println(isAlienSorted(words2, order2));

    }
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 1; i < words.length; i++) {
            int j=0;
            while (j < words[i-1].length() && j < words[i].length() && words[i-1].charAt(j) == words[i].charAt(j) ) {
                if(j == words[i-1].length()-1) break;
                if(j == words[i].length()-1) return false;
                j++;
            }
            if(map.get(words[i-1].charAt(j)) > map.get(words[i].charAt(j))) return false;

        }
        return true;
    }
}
