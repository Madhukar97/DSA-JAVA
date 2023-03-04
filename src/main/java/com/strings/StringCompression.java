package com.strings;

//https://leetcode.com/problems/string-compression/submissions/909031200/
public class StringCompression {
    public static void main(String[] args) {
        char[] chars = {'a','b'};

        char c = chars[0];
    }

    public int compress(char[] chars) {
        String str = "";
        int count = 0;
        int p1 = 0;

        while(p1 < chars.length){
            count=1;
            while(p1+1 < chars.length && chars[p1]==chars[p1+1]){
                count++;
                p1++;
            }
            str=str+chars[p1];
            if(count > 1) str = str+count;
            p1++;
        }
        for(int i=0; i<chars.length; i++){
            chars[i] = str.charAt(i);
        }
        return str.length();

    }

    //optimized sol with timeComplexity O(n) and spaceComplexity O(1) 1ms
    public int compress2(char[] chars) {
        int count = 0;
        int p1 = 0;
        int j = 0;

        while(p1 < chars.length){
            count=1;
            while(p1+1 < chars.length && chars[p1]==chars[p1+1]){
                count++;
                p1++;
            }

            chars[j] = chars[p1];
            j++;
            if(count > 1) {
                String num = String.valueOf(count);
                for(int k=0; k<num.length();k++){
                    chars[j++] = num.charAt(k);
                }
            }
            p1++;
        }
        return j;
    }
}
