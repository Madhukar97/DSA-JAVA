package com.arrays;

import java.util.*;

//amazon OA Q1
public class FIndInfo {

    public static void main(String[] args) {
        int[] arr = {2,1,2,3};
        calcMaxInfo(arr);
    }

    public static void calcMaxInfo(int[] arr){
        int n= arr.length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a1, a2 )-> {
            if(a2[0] == a1[0]) return a2[1]-a1[1];
            return a2[0]-a1[0];
        });
        for(int i=0;i<n;i++) maxHeap.offer(new int[]{arr[i], i});

        int val = n;
        int[] ans = new int[n];

        while(!maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();
            ans[curr[1]] = val;
            val--;
        }
        System.out.println("ans : " + Arrays.toString(ans));
    }

//    public static void main(String[] args) {
//        int[] data2 = {2,1,2};
//        int[] data3 = {2,4,5,3};
//        int[] data = {2,1,2,3};
//        int maxInfo = 0;
//        List finalAns = new ArrayList<Integer>();
//
//
//        int[] arr = new int[data.length];
//        for(int i=0;i<data.length;i++) arr[i] = i+1;
//        List<List<Integer>> ans = permute(arr);
//        ans.sort((a, b) -> {
//            int minLength = Math.min(a.size(), b.size());
//            for (int i = 0; i < minLength; i++) {
//                if (!a.get(i).equals(b.get(i))) {
//                    return a.get(i) - b.get(i); // Compare element by element
//                }
//            }
//            return a.size() - b.size(); // Compare by length if all elements are equal
//        });
//        int[] infoGains = new int[ans.size()];
//        int c =0;
//        for(List<Integer> perm : ans){
//            int calcInfo = 0;
//            for(int i=0;i<perm.size();i++) calcInfo += (i+1)*data[perm.get(i)-1];
//            infoGains[c++] = calcInfo;
//            if(calcInfo > maxInfo) {
//                finalAns = perm;
//                maxInfo = calcInfo;
//            }
//            System.out.println("perm : " + perm + " : infoGain : " + calcInfo);
//        }
//        System.out.println(ans);
//        System.out.println(finalAns);
//        System.out.println(Arrays.toString(infoGains));
//    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void rec(int[] nums, int index, List<List<Integer>> ans, List<Integer> perm){
        if(index == nums.length){
            if(perm.size() == nums.length) ans.add(new ArrayList<>(perm));
            return;
        }

        //not pick
        rec(nums, index+1, ans, perm);
        //pick
        if(!perm.contains(nums[index])){
            perm.add(nums[index]);
            rec(nums, 0, ans, perm);
            perm.remove(perm.size()-1);
        }
    }















//    public static void main(String[] args) {
//        int[] arr = {2,1,2};
//        System.out.println(permute(arr, 3));
//    }
//    public static int[] permute(int[] array, int n) { // nums 1 to n
//        n = array.length;
//        int[] info = new int[1];
//        int[] arr = {2,1,2};
//
//        int[] permutation = new int[n];
//        for(int i=0;i<n;i++) permutation[i] = i+1;
//
//        int[] ans = permutation.clone();
//        rec(permutation, 0, arr, new ArrayList<>(n), info, ans);
//        return ans;
//    }
//
//    public static void rec(int[] nums, int index, int[] arr, List<Integer> perm, int[] maxInfo, int[] ans){
//        if(index == nums.length){
//            int calcInfo = 0;
//            for(int i=0;i< arr.length;i++) calcInfo += i * arr[perm.get(i)-1];
//            if(calcInfo > maxInfo[0]){
//                maxInfo[0] = calcInfo;
//                for(int i=0;i< arr.length;i++) ans[i] = perm.get(i);
//            }
//            else if(calcInfo == maxInfo[0]){
//                ans = findLexigographicallySmall(perm, ans);
//            }
//            return;
//        }
//
//        //not pick
//        rec(nums, index+1, arr, perm, maxInfo, ans);
//        //pick
//        if(!perm.contains(nums[index])){
//            perm.add(nums[index]);
//            rec(nums, 0, arr, perm, maxInfo, ans);
//            perm.remove(perm.size()-1);
//        }
//    }
//
//    public static int[] findLexigographicallySmall(List<Integer> perm, int[] arr){
//        int[] ans = new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            if(perm.get(i) < arr[i]) {
//                for(int j=0;j<arr.length;j++) ans[j] = perm.get(j);
//                return ans;
//            }
//        }
//        return arr;
//    }
}
