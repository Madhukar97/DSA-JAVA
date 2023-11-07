package com.arrays;

import java.util.*;

public class SumOfTwo {

    public static void main(String[] args) {
        SumOfTwo obj = new SumOfTwo();
        int[] ans = obj.twoSum2(new int[]{3,2,4},6);
        System.out.println(Arrays.toString(ans));
    }

    //brute force solution O(n^2) time complexity
    public int[] twoSum(int[] nums, int target) {

        int x=0;
        int y = -1;
        int num1=0,num2=0;
        for (int i=0;i<=nums.length-2;i++){
            num1=nums[i];
            for (int j=i+1;j<=nums.length-1;j++){

                if(nums[i] + nums[j] == target) {
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        return new int[]{x,y};
    }

    // dynamic programming solution O(n) time complexity
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                ans[0] = map.get(nums[i]);
                ans[1] = i;
            }
            else map.put(target-nums[i], i);
        }
        return ans;
    }

    //Optimal sol 2 using sorting and Node class and arrayList
    public int[] twoSum3(int[] nums, int target) {
        List<Node> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(new Node(i, nums[i]));
        }

        Collections.sort(list, (o1,o2)->o1.val-o2.val);
        int i=0;
        int j=nums.length-1;
        while(i < j){
            int sum = list.get(i).val+list.get(j).val;
            if(sum == target) return new int[]{list.get(i).i,list.get(j).i};
            else if(sum > target) j--;
            else i++;
        }
        return new int[]{0,0};
    }

    public class Node{
        int i;
        int val;

        public Node(int i, int v){
            this.i=i;
            this.val=v;
        }
    }
}
