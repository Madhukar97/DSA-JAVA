package com.dsa.strings;


public class Pattern3 {
    public static void main(String[] args) {
        pattern4(5);

    }

    static void pattern3(int n) {
        for (int row = n; row >= 0 ; row--) {
            for (int col = 0; col <= row ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row < 2*n; row++) {
            if ( row <= n) {
                for (int col1 = 1; col1 <= row; col1++) {
                    System.out.print("* ");
                }
                System.out.println("");
            } else {
                for (int col2 = 0; col2 < 2*n - row; col2++) {
                    System.out.print("* ");
                }
                System.out.println("");
            }
        }
    }
}
