package com.dsa.strings;

//Removing a particular character in a string using recursion
public class FilterString {
    public static void main(String[] args) {
        String str = "baccdah";
        processString("", str);
        System.out.println(processString2(str));
    }

    static void processString(String processed, String unProcesses) {
        if ( unProcesses.length() == 0 ) {
            System.out.println(processed);
            return;
        }
        char c = unProcesses.charAt(0);
        if ( c == 'a') processString(processed, unProcesses.substring(1));
        else processString( processed + c , unProcesses.substring(1));
    }

    static String processString2(String str) {
        if ( str.isEmpty() ) return "";
        if ( str.charAt(0) == 'a') return processString2(str.substring(1));
        else return str.charAt(0) + processString2(str.substring(1));
    }
}
