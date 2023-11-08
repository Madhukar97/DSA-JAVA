package com.bitmanipulation;

//371. Sum of Two Integers
//https://leetcode.com/problems/sum-of-two-integers/description/
public class SumOfTwoIntegers {
    //Optimal sol using bit manipulation
    public int getSum(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;
        int carry=0;

        while(b != 0){
            //First, we can use "and"("&") operation between a and b to find a carry.
            carry = a&b;
            //Second, we can use "xor" ("^") operation between a and b to find the different bit, and assign it to a
            a = a^b;
            //Then, we shift carry one position left and assign it to b
            b = carry<<1;
        }
        return a;
    }
}
