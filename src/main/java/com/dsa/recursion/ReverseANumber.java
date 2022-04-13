package com.dsa.recursion;

public class ReverseANumber {
    public static void main(String[] args) {
        System.out.println(reverse(654321, 0));
    }

    static int reverse(int n, int reverse) {
        if ( n< 10 ) return reverse*10 + n;
        return reverse(n/10, reverse*10 + n%10) ;
    }
}
