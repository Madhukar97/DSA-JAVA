package com.slidingwindowtwopointer;

import java.util.*;

//2024. Maximize the Confusion of an Exam
//https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
public class MaximizeTheConfusionOfAnExam {
    class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            Map<Character,Integer> map = new HashMap<>();
            int s=0;
            int e=0;
            int max=0;
            while(s<=e && e < answerKey.length()){
                char left = answerKey.charAt(s);
                char right = answerKey.charAt(e);
                map.put(right, map.getOrDefault(right, 0)+1);
                if(isValidWindow(map, k)) max = Math.max(e-s+1, max);
                else {
                    if(map.get(left) == 1) map.remove(left);
                    else map.put(left, map.get(left)-1);
                    s++;
                }
                e++;
            }
            return max;
        }

        private boolean isValidWindow(Map<Character,Integer> map, int k){
            int maxFreq = 0;
            int totalFreq = 0;
            for(int val : map.values()){
                totalFreq+=val;
                maxFreq = Math.max(maxFreq, val);
            }
            return totalFreq-maxFreq <= k;
        }
    }
}
