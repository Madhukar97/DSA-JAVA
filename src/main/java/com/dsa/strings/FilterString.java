package com.dsa.strings;

//Removing a particular character in a string using recursion
public class FilterString {
    public static void main(String[] args) {
        String str = "baccdah";
        processString("", str);
        System.out.println(processString2(str));
    }

    static void processString(String processed, String unProcessed) {
        if ( unProcessed.length() == 0 ) {
            System.out.println(processed);
            return;
        }
        if ( unProcessed.startsWith("a")) processString(processed, unProcessed.substring(1));
        else processString( processed + unProcessed.charAt(0) , unProcessed.substring(1));
    }

    static String processString2(String str) {
        if ( str.isEmpty() ) return "";
        if ( str.charAt(0) == 'a') return processString2(str.substring(1));
        else return str.charAt(0) + processString2(str.substring(1));
    }
}
