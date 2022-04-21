package com.math;

//7. Reverse Integer
//https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }
    public static int reverse(int x) {
        if (x ==0 ) return x;
        long num = 0;
        if(x > 0){
            while(x > 0){
                num = num * 10 + x % 10;
                x = x/10;
                if(num > Integer.MAX_VALUE) return 0;
            }
        } else {
            while(x < 0){
                num = num * 10 + x % 10;
                x = x/10;
                if(num < Integer.MIN_VALUE) return 0;
            }
        }
        return (int)num;
    }
}
