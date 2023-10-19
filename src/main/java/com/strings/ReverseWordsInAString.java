package com.strings;

//151. Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsInAString {
    //Optimal sol with time O(n) and space O(1)
    public String reverseWords(String s) {
        String ans="";
        int left=0;
        int right=s.length()-1;

        String word="";
        while(left <= right){
            char c = s.charAt(left);
            if(c != ' '){
                word+=c;
            }else if(word.length()>0){
                if(ans.isEmpty()){
                    ans=word;
                }else{
                    ans=word+" "+ans;
                }
                word="";
            }
            left++;
        }
        if(word.length()>0) {
            if(ans.isEmpty()) return word;
            else ans=word+" "+ans;
        }
        return ans;
    }
}
