package com.arrays;

import java.util.ArrayList;
import java.util.List;

//Find all subsets of an array using iteration
public class FindAllSubsets {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> subsets = subsets(arr);
        for ( List<Integer> list : subsets) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        for( int num : arr ) {
            int n = outerList.size();
            for (int i = 0; i < n; i++) {
                List<Integer> innerList = new ArrayList<>(outerList.get(i));
                innerList.add(num);
                outerList.add(innerList);
            }
        }
        return outerList;
    }
}
