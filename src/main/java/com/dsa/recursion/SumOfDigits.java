package com.dsa.recursion;

//Calc the sum of all digits of a num using recursion
public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1234));
    }

    static int sumOfDigits(int n) {
        if ( n < 10 ) return n;
        return n % 10 + sumOfDigits( n / 10 );
    }
}
