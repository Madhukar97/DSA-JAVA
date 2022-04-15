package com.dsa.strings;

// Print all possible permutations of a given string using recursion
public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        permutations("", str);
    }

    static void permutations(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unProcessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String f = processed.substring(0,i);
            String l = processed.substring(i);
            permutations(f+ch+l, unProcessed.substring(1));
        }

    }
}
