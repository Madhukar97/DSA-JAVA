package com.maps;

import java.util.*;

//Count Distinct Element in Every K Size Window
//https://www.codingninjas.com/studio/problems/920336?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
public class CountDistinctElementInEveryKSizeWindow {
    //using HashMap : store/update the frequency of every element in window and remove out of range elements if freq == 1
    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList();

        for(int i=0;i<k;i++){
            map.put(arr.get(i),map.getOrDefault(arr.get(i),0)+1);
        }
        ans.add(map.size());

        for(int i=k;i<arr.size();i++){
            int lastNum = arr.get(i-k);
            int freq = map.get(lastNum);
            if(freq == 1) map.remove(lastNum);
            else map.put(lastNum,map.get(lastNum)-1);
            map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
            ans.add(map.size());
        }
        return ans;
    }
}
