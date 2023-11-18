package com.strings;

//151. Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/description/
public class ReverseWordsInAString {
    //Optimal sol with time O(n) and space O(n)
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

    //Most optimal sol In place with TC = O(n) and space O(1)
    public String reverseWordsSol2(String s) {
        int n=s.length();
        int i=n-1;
        int j=n-1;

        while(i>=0){
            if(s.charAt(j) == ' '){
                i--;
                j--;
                continue;
            }

            if(s.charAt(i) != ' '){
                i--;
                continue;
            }
            s=s+s.substring(i,j+1);
            j=i;
        }
        if(i==-1 && j>=0) s=s+" "+s.substring(0,j+1);
        s=s.substring(n,s.length());
        if(s.charAt(0) == ' ') s=s.substring(1,s.length());
        return s;
    }
}
