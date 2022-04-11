package com.dsa.maths;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 36;
        int precision = 3;
        System.out.println(squareRoot2(n, precision));
    }

    // log(n) time complexity
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
            //mid = start + (end-start)/2;
            mid = Double.valueOf(String.format("%." + i+1 + "f", start + (end-start)/2));
        }
        return mid;
    }

    // log(n) time complexity DSA video solution
    static double squareRoot2(int n, int p) {
        int start = 0;
        int end = n;
        double root = 0.0;
//        while ( start <= end ) {
//            int mid = start + (end - start)/2 ;
//            if ( mid*mid == n) return mid;
//            if ( mid*mid > n ) end = mid - 1;
//            else start = mid + 1 ;
//        }
        double increment = 0.1;
        for (int i = 0; i < p; i++) {
            while ( root*root <= n) {
                root+=increment;
            }

            root-=increment;
            increment/=10;
        }
        return root;
    }
}
