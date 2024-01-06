package com.stackandqueue;

import java.util.Arrays;

//556. Next Greater Element III
//https://leetcode.com/problems/next-greater-element-iii/description/
public class NextGreaterElementIII {
    class Solution {
        public int nextGreaterElement(int n) {
            String num = ""+n;
            char[] digits = new char[num.length()];
            for(int i=0;i<num.length();i++) digits[i] = num.charAt(i);

            int pivot=num.length()-1;
            while(pivot>0){
                if(digits[pivot-1] < digits[pivot]) break;
                pivot--;
            }
            if(pivot == 0) return -1;
            // System.out.println("pivot : " + pivot);

            int nextGreater = pivot;
            for(int i=pivot;i<num.length() && pivot>0;i++){
                if(digits[i] > digits[pivot-1] && digits[i] < digits[nextGreater]) nextGreater = i;
            }

            //replace
            if(pivot > 0){
                char temp = digits[pivot-1];
                digits[pivot-1] = digits[nextGreater];
                digits[nextGreater] = temp;
            }

            Arrays.sort(digits, pivot, digits.length);

            String ans = "";
            for(char i : digits) ans+=i;

            String max = ""+Integer.MAX_VALUE;
            if(ans.length() < max.length()) return Integer.parseInt(ans);

            for(int i=0;i<max.length();i++){
                if(ans.charAt(i) < max.charAt(i)) break;
                else if(ans.charAt(i) > max.charAt(i)) return -1;
            }
            return Integer.parseInt(ans);
        }
    }
}
