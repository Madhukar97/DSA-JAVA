package com.dsa.maths;

//Print all prime numbers in a given range in nLog(Log(n)) time complexity
public class PrimesInRange {
    public static void main(String[] args) {
        int n=40;
        boolean[] arr = new boolean[n+1];       //Take a boolean array with default values as false
        primes(arr);
    }

    static void primes(boolean[] primes) {
        for (int i = 2; i*i < primes.length; i++) {
            if (!primes[i]) {
                for (int j = i*2; j < primes.length; j+=i) {
                    primes[j] = true;           // If the number is a prime(value=false) make all its multiples non primes(value=true)
                }
            }
        }
        for (int i = 2; i < primes.length; i++) {
            if(!primes[i]) System.out.print(i+" ");
        }
    }
}
