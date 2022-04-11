package com.dsa.maths;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 10;
        int precision = 4;
        System.out.println(squareRoot(n, precision));
    }
    
    static double squareRoot(int n, int p) {
        double start=0;
        double end=n;
        double mid = 0;
        while (start <= end) {
            mid = (int)(start + (end-start)/2);
            if ( mid*mid == n) return mid;
            if ( mid*mid < n) start = mid+1;
            if ( mid*mid > n ) end = mid-1;
        }
        mid = (int)(start + (end-start)/2);

        for (int i = 1; i <= p ; i++) {
            start=mid;
            end=start+10/(Math.pow(10, i));
            while ( start <= end ) {
                mid = Double.valueOf(String.format("%." + i + "f", start + (end-start)/2));
                if (mid * mid == n) return mid;
                if (mid * mid < n) {
                    start = mid + 1/Math.pow(10, i);
                }else end = mid - 1/Math.pow(10, i);
            }
            mid = start + (end-start)/2;
        }
        return mid;
    }
}
