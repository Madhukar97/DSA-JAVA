package com.arrays;

//2938. Separate Black and White Balls
//https://leetcode.com/contest/weekly-contest-372/problems/separate-black-and-white-balls/
public class SeparateBlackAndWhiteBalls {
    //Brute force solution with TC = exp and SC = O(n);
    class Solution {
        public long minimumSteps(String s) {
            long swaps=0;
            int[] balls = new int[s.length()];
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '1') balls[i] = 1;
            }

            long count=0;
            while(true){
                int i=0;
                int j=1;
                count = 0;
                while(j < s.length()){
                    if(balls[i] ==1 && balls[j]==0){
                        balls[i++]=0;
                        balls[j++]=1;
                        count++;
                    }else {
                        i++;
                        j++;
                    }
                }
                // System.out.println("Arr : " + Arrays.toString(balls));
                swaps+=count;
                if(count == 0) break;
            }
            return swaps;
        }
    }
    //Optimal sol with TC = O(n) and SC = O(n);
    class Solution2 {
        public long minimumSteps(String s) {
            long swaps=0;
            int[] balls = new int[s.length()];
            for(int i=0;i<s.length();i++){
                if(s.charAt(i) == '1') balls[i] = 1;
            }

            int i=0;
            int j=0;
            while(i<balls.length && j<balls.length){
                if(balls[i] == 0) {
                    i++;
                }else if(i >= j) j=i+1;
                else if(balls[j] == 0){
                    swaps+=j-i;
                    balls[j++]=1;
                    balls[i++]=0;
                }
                else j++;
            }
            return swaps;
        }
    }
    //
}
