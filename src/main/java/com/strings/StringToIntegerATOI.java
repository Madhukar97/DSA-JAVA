package com.strings;

//8. String to Integer (atoi)
//https://leetcode.com/problems/string-to-integer-atoi/description/
public class StringToIntegerATOI {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int positive = 0;
        int negative = 0;
        if (i<n && s.charAt(i) == '+') {
            positive++;
            i++;
        }
        if (i<n && s.charAt(i) == '-') {
            negative++;
            i++;
        }

        double ans = 0;

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            ans = ans * 10 + (s.charAt(i) - '0');
            i++;
        }

        if (negative > 0) {
            ans = -ans;
        }
        if (positive > 0 && negative > 0) {
            return 0;
        }

        if (ans > Integer.MAX_VALUE) {
            ans = Integer.MAX_VALUE;
        }

        if (ans < Integer.MIN_VALUE) {
            ans = Integer.MIN_VALUE;
        }

        return (int) ans;
    }
}
