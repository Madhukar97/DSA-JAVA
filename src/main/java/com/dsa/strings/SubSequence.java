package com.dsa.strings;

//Find all possible sub sequences of the given string
public class SubSequence {
    public static void main(String[] args) {
        String str = "abc";
        subSequence("", str);
    }

    static void subSequence(String subSeq, String str) {
        if ( str.isEmpty() ) {
            System.out.println(subSeq);
            return;
        }
        // In each recursion call either you add the 1st character to subSeq or you don't
        subSequence(subSeq + str.charAt(0), str.substring(1));
        subSequence(subSeq , str.substring(1));
    }
}
