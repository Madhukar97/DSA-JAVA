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
}
