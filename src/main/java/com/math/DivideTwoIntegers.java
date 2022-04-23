package com.math;

//29. Divide Two Integers
//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegers {
    public static void main(String[] args) {

    }

    public int divide(int dividend, int divisor) {
        long quoe = (long)dividend/divisor;
        if(quoe > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(quoe < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)quoe;
    }
}
