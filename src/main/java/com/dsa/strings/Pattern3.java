package com.dsa.strings;

//Print inverted triangle pattern
public class Pattern3 {
    public static void main(String[] args) {
        pattern3(5);
    }

    static void pattern3(int n) {
        for (int row = n; row >= 0 ; row--) {
            for (int col = 0; col <= row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
