package com.strings;

import java.util.*;

//299. Bulls and Cows
//https://leetcode.com/problems/bulls-and-cows/description/
public class BullsAndCows {
    class Solution {
        public String getHint(String secret, String guess) {
            int bulls=0;
            int cows=0;
            Map<Integer,Integer> map = new HashMap<>();

            for(int i=0;i<secret.length();i++){
                int digit = secret.charAt(i)-'0';
                map.put(digit, map.getOrDefault(digit, 0)+1);
            }

            for(int i=0;i<guess.length();i++){
                int digit = guess.charAt(i) - '0';
                if(secret.charAt(i) == guess.charAt(i)){
                    bulls++;
                    map.put(digit, map.get(digit)-1);
                    if(map.get(digit) == 0) map.remove(digit);
                }
            }

            for(int i=0;i<guess.length();i++){
                int digit = guess.charAt(i) - '0';
                if(secret.charAt(i) != guess.charAt(i) && map.containsKey(digit)){
                    cows++;
                    map.put(digit, map.get(digit)-1);
                    if(map.get(digit) == 0) map.remove(digit);
                }
            }
            return bulls+"A"+cows+"B";
        }
    }
}
