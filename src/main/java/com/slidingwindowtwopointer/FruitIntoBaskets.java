package com.slidingwindowtwopointer;

import java.util.*;

//904. Fruit Into Baskets
//https://leetcode.com/problems/fruit-into-baskets/description/
public class FruitIntoBaskets {
    class Solution {
        public int totalFruit(int[] fruits) {
            Map<Integer,Integer> map = new HashMap<>();
            int s=0,e=0,max=0;
            while(e < fruits.length){
                map.put(fruits[e], map.getOrDefault(fruits[e], 0)+1);
                if(map.size() <= 2) max = Math.max(max, e-s+1);
                else {
                    if(map.get(fruits[s]) == 1) map.remove(fruits[s]);
                    else map.put(fruits[s], map.get(fruits[s])-1);
                    s++;
                }
                e++;
            }
            return max;
        }
    }
}
