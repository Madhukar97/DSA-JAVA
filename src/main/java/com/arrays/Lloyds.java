package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class Lloyds {
    public static void main(String[] args) {
        String[] words = {"hello","Hello-world","hello","Hello"}; //20
        List<String> ans = concat(words, 20);
        System.out.println(ans.toString());

    }

    public static List<String> concat(String[] words, int maxLen){
        List<String> ans = new ArrayList<>();
        String str = "";
        int i=0;
        while (i<words.length){
            if(str.length() > 0){
                if(str.length() + words[i].length() + 1 <= maxLen){
                    str = str + "-" + words[i];
                    i++;
                }else{
                    ans.add(str);
                    str="";
                }
            }else{
                str = words[i];
                i++;
            }
        }
        ans.add(str);

        return ans;
    }

}
